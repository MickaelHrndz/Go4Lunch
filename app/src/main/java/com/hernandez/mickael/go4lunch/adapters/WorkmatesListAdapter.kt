package com.hernandez.mickael.go4lunch.adapters

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hernandez.mickael.go4lunch.R
import com.hernandez.mickael.go4lunch.model.Restaurant
import com.hernandez.mickael.go4lunch.model.Workmate
import kotlinx.android.synthetic.main.row_workmate.view.*

/**
 * Created by Mickael Hernandez on 08/02/2018.
 */
open class WorkmatesListAdapter(context: Context, resource: Int, list: ArrayList<Workmate>) : RecyclerView.Adapter<WorkmatesListAdapter.ViewHolder>() {
    private var mContext = context
    private var mResource = resource
    private var mList = list

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WorkmatesListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.row_workmate, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        //holder.tag = item.restaurantId
        // If this workmate hasn't picked a restaurant yet
        if(item.restaurantId == null){
            holder.textView.text = mContext.getString(R.string.text_notdecided, item.displayName)
            holder.textView.setTypeface(null, Typeface.ITALIC)

        } else {
            holder.textView.text = mContext.getString(R.string.text_workmate, item.displayName, item.restaurantName)
            holder.textView.setTypeface(null, Typeface.BOLD)
        }

        // Profile image
        Glide.with(mContext).load(item.photoUrl).into(holder.itemView.findViewById(R.id.image_workmate))

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.text_workmate!!
    }
}