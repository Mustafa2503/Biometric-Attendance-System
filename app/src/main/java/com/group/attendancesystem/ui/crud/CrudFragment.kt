package com.group.attendancesystem.ui.crud

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.group.attendancesystem.R
import com.group.attendancesystem.ui.auth.RegisterFragment
import kotlinx.android.synthetic.main.fragment_crud.view.*

class CrudFragment : Fragment() {

    lateinit var mView:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_crud, container, false)
        onClick()
        return mView
    }


    private fun onClick() {
        mView.update.setOnClickListener {
            val updateFragment = UpdateFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.crud_container, updateFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        mView.addAttendance.setOnClickListener {
            val addAttendanceFragment = AddAttendanceFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.crud_container, addAttendanceFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        mView.downloadData.setOnClickListener {
            val downloadFragment = DownloadFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.crud_container, downloadFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        mView.delete.setOnClickListener {
            val deleteFragment = DeleteFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.crud_container, deleteFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}
