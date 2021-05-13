package com.example.expensemanagement.view


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import com.android.duongnk.library.commonfuntions.CommonFuntions
import com.example.expensemanagement.R
import com.example.expensemanagement.base.fragment.BaseFragment
import com.example.expensemanagement.base.view.AppToolbar
import com.example.expensemanagement.datasingerten.DataApplicationSingleton
import com.example.expensemanagement.datasingerten.Expen
import com.example.expensemanagement.model.ExpenseModel
import kotlinx.android.synthetic.main.add_expense_fragment.*


@Suppress("DEPRECATION")
class AddExpenseFragment : BaseFragment() {


    private lateinit var viewModel: AddExpenseViewModel
    var arr = DataApplicationSingleton.instance.getArrA()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_expense_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddExpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setToolbar(AppToolbar.Builder().setTitle("Tạo lịch sử chi tiêu").setOnBackPress(View.OnClickListener {
            println(
                mFragmentNavigation.back()
            )
        }).build())
        Log.e("duongk", mPreferences!!.getString("duongnk"))
        CommonFuntions.setDigitsEditText(edtAmount,"",5)
        val arrS = ArrayList<String>()
        arrS.add("Mua sắm")
        arrS.add("Đi ăn nhậu")
        arrS.add("Đi ăn đám")
        arrS.add("Đi chơi với người yêu")

        val adapter = ArrayAdapter<String>(
            activity!!,
            R.layout.support_simple_spinner_dropdown_item,
            arrS
        )
        spinnerTypeTrans.adapter = adapter


        val arrSType = ArrayList<String>()
        arrSType.add("Tiền ra")
        arrSType.add("Tiền vào")

        val adapterType = ArrayAdapter<String>(
            activity!!,
            R.layout.support_simple_spinner_dropdown_item,
            arrSType
        )
        spinnerTypeFush.adapter = adapterType

        btnAddEx.setOnClickListener {
            val ex = Expen("duongnk")
            val expenseModel = ExpenseModel(
                spinnerTypeTrans.selectedItem.toString(),
                spinnerTypeFush.selectedItem.toString(),
                edtAmount.text.toString()
            )
            arr.add(expenseModel)
            DataApplicationSingleton.instance.setArrA(arr)
            mFragmentNavigation.back()
            ex.set = "lồn"
            try {
                val imm =
                    context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(getView()!!.windowToken, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
