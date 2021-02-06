package com.android.duongnk.library.commonfuntions

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.text.format.DateFormat
import android.util.Base64
import android.widget.EditText
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object CommonFuntions {
    var clientCache: HashMap<String, Any>? = null
    var formatter: DecimalFormat? = null
    private val suffixes: NavigableMap<Long, String> = TreeMap()

    init {
        print("CommonFuntions - init")
        clientCache = HashMap()

        suffixes[1_000L] = "k"
        suffixes[1_000_000L] = "M"
        suffixes[1_000_000_000L] = "G"
        suffixes[1_000_000_000_000L] = "T"
        suffixes[1_000_000_000_000_000L] = "P"
        suffixes[1_000_000_000_000_000_000L] = "E"
    }

    /**
     * input :  CommonFuntions.cvDateToTimeMilliseconds(Date())
     * output:   1610383240478
     * chuyển từ date Object -> LongTime
     */
    fun cvDateToTimeMilliseconds(dateInput: Date): Long? {
        return dateInput.time
    }

    /**
     * input :    CommonFuntions.formatDateToStringWithTimeZone(Date(),"yyyy-MM-dd HH:mm:ss","UTC")
     * output:     2021-01-11 16:39:10
     *
     */
    fun formatDateToStringWithTimeZone(
        date: Date?, format: String?,
        timeZone: String?
    ): String? {
        // null check
        var timeZone = timeZone
        if (date == null) return null
        // create SimpleDateFormat object with input format
        val sdf = if (format.toString().trim()
                .isEmpty()
        ) SimpleDateFormat("yyyy-MM-dd HH:mm:ss") else SimpleDateFormat(format)
        // default system timezone if passed null or empty
        if (timeZone == null || timeZone.toString().trim().isEmpty()) {
            timeZone = Calendar.getInstance().timeZone.id
        }
        // set timezone to SimpleDateFormat
        sdf.timeZone = TimeZone.getTimeZone(timeZone)
        // return Date in required format with timezone as String
        return sdf.format(date)
    }


    /**
     * get tháng trong Date Object
     *
     * @param date
     * @return
     */
    fun getMothInDate(date: Date?): String? {
        return SimpleDateFormat("MM").format(date)
    }

    /**
     * get ngay trong Date Object
     *
     * @param date
     * @return
     */
    fun getDayInDate(date: Date?): String? {
        return DateFormat.format("dd", date) as String
    }

    /**
     * get năm trong Date Object
     *
     * @param Date
     * @return
     */
    fun getYearInDate(date: Date?): String? {
        return DateFormat.format("yyyy", date) as String
    }
    fun getDateNow():String{
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val formatedDate = formatter.format(date)
        return  formatedDate.toString()
    }
    /**
     * input : CommonFuntions.hmsTimeFormatter(66000)
     * out put : 00:01:06
     *
     * chuyển time long thành định giạng HH:mm:ss
     */
    @SuppressLint("DefaultLocale")
    fun hmsTimeFormatter(milliSeconds: Long): String? {
        return String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(milliSeconds),
            TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(milliSeconds)
            ),
            TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds)
            )
        )
    }


    /**
     * input : CommonFuntions.msTimeFormatter(66000)
     * output:  01:06
     *
     * chuyển time long thành định giạng mm:ss
     */
    @SuppressLint("DefaultLocale")
    fun msTimeFormatter(milliSeconds: Long): String? {
        return String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(milliSeconds)
            ),
            TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds)
            )
        )
    }

    /**
     * Set các ký tự được phép nhập trong EditText theo regex được chuyển vào
     */
    fun setDigitsEditText(view: EditText, regex: String, maxLength: Int = 0) {
        view.inputType = InputType.TYPE_CLASS_TEXT
        val filter = InputFilter { src, start, end, dest, dstart, dend ->
            if (src == "") {
                return@InputFilter src
            }
            if (src.toString()
                    .matches(
                        if (regex.toString().trim()
                                .isEmpty()
                        ) "[a-zA-Z0-9!@#$%*]+".toRegex() else regex.toRegex()
                    )
            ) {
                return@InputFilter src
            } else return@InputFilter ""
        }
        view.filters = arrayOf(filter, LengthFilter(if (maxLength == 0) 18 else maxLength))
    }


    /**
     * Lưu dữ liệu vào memory cache theo định dạng Map <K,V>
     */
    fun putCache(key: String?, obj: Any?) {
        if (clientCache == null) {
            clientCache = HashMap()
        }
        clientCache!![key!!] = obj!!
    }

    /**
     * get dữ liệu từ memory cache theo định dạng Map <K,V>
     */
    fun getFromCache(key: String?): Any? {
        return if (clientCache == null) {
            null
        } else clientCache!![key]
    }

    /**
     * clear All dữ liệu ở memory cache
     */
    fun clearCache() {
        clientCache = HashMap()
    }

    /**
     * Chuyển từ Double hoặc Int sang định dạng one number
     * 1000 to 1k
     * 5821 to 5.8k
     * 10500 to 10k
     * 101800 to 101k
     * 2000000 to 2m
     * 7800000 to 7.8m
     * 92150000 to 92m
     * 123200000 to 123m
     */
    fun formatNumber(value: Long): String {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return formatNumber(Long.MIN_VALUE + 1)
        if (value < 0) return "-" + formatNumber(-value)
        if (value < 1000) return java.lang.Long.toString(value) //deal with easy case
        val e = suffixes.floorEntry(value)
        val divideBy = e.key
        val suffix = e.value
        val truncated =
            value / (divideBy / 10) //the number part of the output times 10
        val hasDecimal =
            truncated < 100 && truncated / 10.0 != (truncated / 10).toDouble()
        return if (hasDecimal) (truncated / 10.0).toString() + suffix else (truncated / 10).toString() + suffix
    }


    /**
     * format định dạng tiền ###,###,### + Đơn vị tiền tệ (currencyUnit)
     * input : CommonFuntions.formatCurrency(80000000,"VND")
     * output : 80,000,000 VND
     */
    fun formatCurrency(money: Int?, currencyUnit: String = ""): String? {
        if (money == null) {
            return "0 đ"
        }
        if (formatter == null) {
            formatter =
                DecimalFormat("###,###,###")
        }
        return formatter?.format(money) + if (currencyUnit.trim()
                .isEmpty()
        ) " VNĐ" else " $currencyUnit"
    }

    /**
     * Tạo Dialog thông báo hệ thống
     * context = Activity
     */
    fun createAlertDialog(
        context: Context,
        title: String,
        message: String,
        confirmButton: String,
        onClickListener: DialogInterface.OnClickListener
    ): AlertDialog {
        val builderToken = AlertDialog.Builder(context)
        builderToken.setCancelable(false)
        builderToken.setTitle(title)
        builderToken.setMessage(message)
        builderToken.setPositiveButton(
            confirmButton,
            onClickListener
        )
        return builderToken.create()
    }

    /**
     * Encode ảnh về base 64
     *
     * @param bm
     * @return
     */
    fun encodeImage(bm: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    /**
     * Endcode base 64
     *
     * @param text
     * @return
     */
    fun encodeBase64(text: String): String? {
        return try {
            val data = text.toByteArray(charset("UTF-8"))
            Base64.encodeToString(data, Base64.DEFAULT)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Decode base 64
     *
     * @param base64
     * @return
     */
    fun decodeBase64(base64: String?): String? {
        return try {
            val data: ByteArray =
                Base64.decode(base64, Base64.DEFAULT)
            val charset: Charset = charset("UTF-8")
            val value = String(data, charset)
            return value
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}