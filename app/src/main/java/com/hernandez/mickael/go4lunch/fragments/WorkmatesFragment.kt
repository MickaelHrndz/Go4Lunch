package com.hernandez.mickael.go4lunch.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.hernandez.mickael.go4lunch.R
import com.hernandez.mickael.go4lunch.activities.RestaurantActivity
import com.hernandez.mickael.go4lunch.adapters.RestaurantListAdapter
import com.hernandez.mickael.go4lunch.adapters.WorkmatesListAdapter
import com.hernandez.mickael.go4lunch.model.Restaurant
import com.hernandez.mickael.go4lunch.model.Workmate
import java.io.ByteArrayOutputStream

/**
 * Created by Mickael Hernandez on 24/01/2018.
 */
class WorkmatesFragment : Fragment() {

    private var workmatesList = ArrayList<Workmate>()

    private lateinit var mAdapter: WorkmatesListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val convertView = inflater.inflate(R.layout.fragment_workmates, container, false)

        // Setting up list and its adapter
        mAdapter = WorkmatesListAdapter(context!!, R.layout.row_workmate, workmatesList)
        convertView.findViewById<ListView>(R.id.list_workmates).adapter = mAdapter

        // Item click listener
        convertView.findViewById<ListView>(R.id.list_workmates).setOnItemClickListener { adapterView, view, i, l ->

        }
        return convertView
    }

    fun setWorkmates(list: ArrayList<Workmate>){
        workmatesList = list
        if(::mAdapter.isInitialized && context != null){
                mAdapter.notifyDataSetChanged()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mAdapter = WorkmatesListAdapter(context!!, R.layout.row_workmate, workmatesList)
        mAdapter.notifyDataSetChanged()
    }
}