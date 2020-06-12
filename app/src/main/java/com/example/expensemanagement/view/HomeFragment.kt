package com.example.expensemanagement.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanagement.R
import com.example.expensemanagement.base.adapter.BaseAdapter
import com.example.expensemanagement.base.adapter.ItemViewClickListener
import com.example.expensemanagement.base.fragment.BaseFragment
import com.example.expensemanagement.base.genericValue.GenericClass
import com.example.expensemanagement.model.SinhVien
import com.example.expensemanagement.view.viewHolder.ViewHolderSinhVien
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.ArrayList

class HomeFragment : BaseFragment(), ItemViewClickListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    var mGenericClass: GenericClass<SinhVien> = GenericClass()
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
        var viewHolder = ViewHolderSinhVien(activity!!.window.decorView.rootView, this)
        var baseAdapter =
            BaseAdapter(CreatDataSinhVien(), context!!, R.layout.item_sinhvien, viewHolder)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = baseAdapter


    }

    override fun onItemViewClickListener(position: Int, list: List<*>) {

    }

    fun CreatDataSinhVien(): ArrayList<SinhVien> {
        val arrayList = ArrayList<SinhVien>()
        arrayList.add(SinhVien("Nguyễn Khắc Đường", "15120382"))
        arrayList.add(SinhVien("Nguyễn Đức Nam", "15120123"))
        arrayList.add(SinhVien("Nguyễn Thanh Tùng", "54234324"))
        arrayList.add(SinhVien("Phạm Quang Xếp", "23432423"))
        arrayList.add(SinhVien("Nguyễn Thị Ngọc Trinh", "5234211"))
        arrayList.add(SinhVien("Ma thị Say", "31241255"))
        arrayList.add(SinhVien("Thích Uống Bia", "12314515"))
        arrayList.add(SinhVien("Thần Bia Đại rượu", "125154331"))
        arrayList.add(SinhVien("Lò Văn Thìn", "12414235"))
        return arrayList
    }
}
