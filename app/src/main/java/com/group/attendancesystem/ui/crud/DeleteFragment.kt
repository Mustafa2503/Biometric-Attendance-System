package com.group.attendancesystem.ui.crud

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.group.attendancesystem.R
import com.group.attendancesystem.extension.gotoFrag
import com.group.attendancesystem.extension.showToast
import com.group.attendancesystem.room.DBHelper
import com.group.attendancesystem.room.DBHelperI
import com.group.attendancesystem.room.database.EmployeeDatabase
import com.group.attendancesystem.room.entity.Employee
import com.group.attendancesystem.room.entity.EmployeeAttendance
import kotlinx.android.synthetic.main.fragment_delete.*
import kotlinx.android.synthetic.main.fragment_delete.view.*

class DeleteFragment : Fragment() {

    lateinit var mView:View
    lateinit var dbHelperI: DBHelperI
    var emp_id:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_delete, container, false)
        init()
        onClick()
        return mView
    }

    private fun init() {
        dbHelperI = DBHelper(EmployeeDatabase.getInstance(context!!)!!)
    }

    private fun onClick() {

        mView.deleteEmployee.setOnClickListener {
            getEmpCode()
        }

        mView.deleteAttendance.setOnClickListener {
            getEmpCodeForAttendance()
        }
    }


    private fun getEmpCode() {

        if (edEmpCode.text.toString().isEmpty()){
            edEmpCode.error = "Employee code"
            edEmpCode.requestFocus()
            return
        }

        val employee:Employee = dbHelperI.selectEmployeeDetails(context, edEmpCode.text.toString())
        emp_id = employee.id!!

        val employeeData = Employee(
            id = emp_id
        )

        deleteUser(employeeData)
    }

    private fun getEmpCodeForAttendance() {

        if (edEmpAttendanceCode.text.toString().isEmpty()){
            edEmpAttendanceCode.error = "Employee code"
            edEmpAttendanceCode.requestFocus()
            return
        }
        val employee: EmployeeAttendance = dbHelperI.selectAttendanceDetails(context, edEmpAttendanceCode.text.toString())
        emp_id = employee.id!!

        val employeeData = Employee(
            id = emp_id
        )

        deleteEmployeeAttendance(employee)
    }

    private fun deleteUser(employeeData: Employee) {
        dbHelperI.deleteAllEmployees(employeeData,context)
        context!!.showToast("user deleted")
        goBack()
    }

    private fun deleteEmployeeAttendance(attendance: EmployeeAttendance) {
        dbHelperI.deleteAttendance(context, attendance)
        context!!.showToast("attendance deleted")
        goBack()
    }

    private fun goBack() {
        context!!.gotoFrag(activity!!)
    }
}
