package com.example.expensemanagement.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.duongnk.library.adapter.BaseAdapter
import com.android.duongnk.library.adapter.ItemViewClickListener
import com.android.duongnk.library.baseAplication.BaseFragmentApplication
import com.example.expensemanagement.R
import com.example.expensemanagement.base.genericValue.GenericClass
import com.example.expensemanagement.datasingerten.DataApplicationSingleton
import com.example.expensemanagement.model.ExpenseModel
import com.example.expensemanagement.model.SinhVien
import com.example.expensemanagement.view.viewHolder.ViewHolderItem
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.ArrayList

class HomeFragment : BaseFragmentApplication(), ItemViewClickListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    var mGenericClass: GenericClass<SinhVien> = GenericClass()
    lateinit var baseAdapter : BaseAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        initView()
//        fragmentNavigation.addFragment(AddExpenseFragment())
//        popData(CreatDataSinhVien(), mGenericClass,recyclerView)

    }

    fun <D> popData(
        d: D,
        genericClass: GenericClass<SinhVien>,
        recyclerView: RecyclerView
    ) {

        // set layout manager cho recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        // clear Data Generic
        genericClass.clearList()

        // khi data genericClass thay đổi tự động view adapter sẽ thay đổi và đc cập nhật vì genericClass là kiểu dữ liệu THAM TRỊ
        genericClass.populate(d as SinhVien)

    }

    private fun initView() {
//        this.setToolbar(AppToolbar.Builder().setTitle("Lịch sử chi tiêu").setOnBackPress(View.OnClickListener {
//            println(
//                fragmentNavigation.back()
//            )
//        }).build())
        val viewHolder = ViewHolderItem(activity!!.window.decorView.rootView, this)
         baseAdapter =
            BaseAdapter(CreatDataSinhVien(), context!!, R.layout.item_expense, viewHolder)
        recyclerViewMax.layoutManager = LinearLayoutManager(context)
        recyclerViewMax.adapter = baseAdapter

//        mPreferences.saveString("duongnk","Lưu data thành công")
        Log.e("duongnk",mPreferences.getString("duongnk"))
    }

    override fun onResume() {
        super.onResume()
        baseAdapter!!.notifyDataSetChanged()
        Log.e("duongk","vafo đây")
    }

    override fun onItemViewClickListener(position: Int, list: List<*>) {

    }

    fun CreatDataSinhVien(): ArrayList<ExpenseModel> {
        val arrayList = ArrayList<ExpenseModel>()
        arrayList.add(ExpenseModel("Shopping", "tiền ra", "20,000,000 VND"))
        arrayList.add(ExpenseModel("Shopping", "tiền ra", "20,000,000 VND"))
        arrayList.add(ExpenseModel("Shopping", "tiền ra", "20,000,000 VND"))
        arrayList.add(ExpenseModel("Shopping", "tiền ra", "20,000,000 VND"))
        arrayList.add(ExpenseModel("Shopping", "tiền ra", "20,000,000 VND"))
        return DataApplicationSingleton.instance.getArrA()
    }
}
