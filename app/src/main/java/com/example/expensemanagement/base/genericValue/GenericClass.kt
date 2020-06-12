package com.example.expensemanagement.base.genericValue

/**
 * GenericClass là 1 class có kiểu giá trị dữ liệu tham trị
 * vì là dữ liệu tham chị lên khi có sự thay đổi về data GenericClass tự có thể Updater Data mới cho List
 * @param <D>
 */
class GenericClass<D>{
    var list: ArrayList<D> = ArrayList()

    fun populate(d: D) {
        list.addAll(d as Collection<D>)
    }

    fun getList(): List<D> {
        return list
    }

     fun clearList() {
           list.clear()
     }

}