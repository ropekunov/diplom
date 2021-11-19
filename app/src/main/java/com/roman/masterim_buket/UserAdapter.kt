package com.roman.masterim_buket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userNameList: List<String>) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val userItemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_list_item, parent,false)

        return UserViewHolder(userItemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val userName = userNameList[position]
        holder.bind(userName)

    }

    override fun getItemCount(): Int {
        return userNameList.size
    }

}