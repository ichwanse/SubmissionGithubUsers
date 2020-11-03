package com.dicoding.submissiononegithubusers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissiononegithubuser.model.GithubUsers
import com.dicoding.submissiononegithubuser.model.User

import com.dicoding.submissiononegithubusers.SelectedUserActivity.Companion.EXTRA_USERS

class MainActivity : AppCompatActivity(), OnUserClickListener  {
    private lateinit var rvUser : RecyclerView
    private var list : ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(GithubUsers.listData)
        rvUser.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(list, this)
        rvUser.adapter = adapter
    }

    override fun onItemClick(item: User, position: Int) {
        startActivity(Intent(this, SelectedUserActivity::class.java)
            .putExtra(SelectedUserActivity.EXTRA_USERS, item)
        )

    }

}