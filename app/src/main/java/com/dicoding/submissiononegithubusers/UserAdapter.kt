package com.dicoding.submissiononegithubusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissiononegithubuser.model.User
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter (var user : ArrayList<User>, var clickListener: OnUserClickListener)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userUsername  :TextView = itemView.findViewById(R.id.user_username)
        var userName : TextView = itemView.findViewById(R.id.user_name)
        var userAvatar : CircleImageView = itemView.findViewById(R.id.user_avatar)


        fun initialize(item: User, action: OnUserClickListener){
            userName.text = item.name
            userUsername.text = item.username
            item.avatar?.let { userAvatar.setImageResource(it) }

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent,false))
    }

    override fun getItemCount(): Int {
        return user.size
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
     holder.initialize(user[position],clickListener)
    }


}


interface OnUserClickListener {
    fun onItemClick(item: User, position: Int) {}
}