package com.group.attendancesystem.room

import android.content.Context
import com.group.attendancesystem.room.database.EmployeeDatabase
import com.group.attendancesystem.room.entity.Employee
import com.group.attendancesystem.room.entity.EmployeeAttendance

class DBHelper(var employeeDatabse:EmployeeDatabase):DBHelperI {
    override fun insertEmployeeDetails(
        employeeData: Employee,
        context: Context?
    ) {
        EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()?.insert(employeeData)
    }

    override fun selectEmployeePassword(
        context: Context?,
        employeeData: String
    ):String {
         val credentials:String = EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.selectCredentials(employeeData)
        return credentials
    }

    override fun selectEmployeeFingerprint(context: Context?, empCode: String): Boolean {
        val fingerprint: Boolean = EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.selectFingerPrintValue(empCode)
        return fingerprint
    }

    override fun selectEmployeeDetails(context: Context?, empCode: String): Employee {
        val employee:Employee = EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.selectRow(empCode)
        return employee
    }

    override fun selectAttendanceDetails(context: Context?, empCode: String): EmployeeAttendance {
        val attendance:EmployeeAttendance = EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.getAttendanceDetails(empCode)
        return attendance
    }

    override fun updateDetails(
        employeeData: Employee,
        context: Context?
    ) {
        EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.update(employeeData)
    }

    override fun insertEmployeeAttendance(
        employeeAttendance: EmployeeAttendance,
        context: Context?
    ) {
        EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()?.insertAttendance(employeeAttendance)

    }

    override fun selectEmployeeAttendance(
        context: Context?
    ): List<EmployeeAttendance> {

        val attendance:List<EmployeeAttendance> = EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.getAllEmployees()
        return attendance
    }

    override fun selectEmployees(context: Context?): List<Employee> {
        val employee:List<Employee> = EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.getEmployeeDetails()
        return employee
    }

    override fun deleteAllEmployees(
        employeeData: Employee,
        context: Context?
    ) {
        EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.delete(employeeData)
    }

    override fun deleteAttendance(context: Context?, attendance: EmployeeAttendance) {
        EmployeeDatabase.getInstance(context!!)?.getEmployeeDao()!!.deleteAttendance(attendance)

    }

}