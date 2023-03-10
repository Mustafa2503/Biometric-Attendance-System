package com.group.attendancesystem.room

import android.content.Context
import com.group.attendancesystem.room.entity.Employee
import com.group.attendancesystem.room.entity.EmployeeAttendance

interface DBHelperI {

    fun insertEmployeeDetails(
        employeeData: Employee,
        context: Context?
    )

    fun selectEmployeePassword(
        context: Context?,
        employeeData: String
    ):String

    fun selectEmployeeFingerprint(
        context: Context?,
        empCode:String
    ):Boolean

    fun selectEmployeeDetails(context: Context?, empCode: String):Employee

    fun selectAttendanceDetails(context: Context?, empCode: String):EmployeeAttendance


    fun updateDetails(
        employeeData: Employee,
        context: Context?
    )

    fun insertEmployeeAttendance(employeeAttendance: EmployeeAttendance, context: Context?)

    fun selectEmployeeAttendance(context: Context?):List<EmployeeAttendance>

    fun selectEmployees(context: Context?):List<Employee>

    fun deleteAllEmployees(
        context: Employee,
        context1: Context?
    )

    fun deleteAttendance(
        context: Context?,
        attendance: EmployeeAttendance)
}