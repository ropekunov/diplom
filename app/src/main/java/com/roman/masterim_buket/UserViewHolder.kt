package com.roman.masterim_buket

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(userName:String){
        val userNameTextView:TextView=itemView.findViewById(R.id.user_name_text_view)
        userNameTextView.text=userName
    }

}