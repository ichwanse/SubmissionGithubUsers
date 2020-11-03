package com.dicoding.submissiononegithubusers


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.submissiononegithubuser.model.User
import kotlinx.android.synthetic.main.activity_selected_user.*


class SelectedUserActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_USERS = "extra_users"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_user)

        val user = intent.getParcelableExtra<User>(EXTRA_USERS)

        user_name.text = user?.name
        user_username.text = user?.username
        user_follower.text = user?.follower.toString()
        user_following.text = user?.following.toString()
        user_location.text = user?.location
        user_repository.text = user?.repository.toString()
        user?.avatar?.let { user_avatar.setImageResource(it) }
    }

    fun backToMain(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }


}



