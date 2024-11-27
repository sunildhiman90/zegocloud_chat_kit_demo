package com.example.zimkitdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.zimkit.services.ZIMKit
import im.zego.zim.entity.ZIMError
import im.zego.zim.enums.ZIMErrorCode
import java.util.Random

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initData()
    }

    private fun initData() {
        val prefs = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val userID = prefs.getString("userID", randomUserId())
        val userName = prefs.getString("userName", Utils.randomName())

        val userIDText = findViewById<EditText>(R.id.et_user_id)
        userIDText.setText(userID)

        val userNameText = findViewById<EditText>(R.id.et_user_name)
        userNameText.setText(userName)

        val loginBtn = findViewById<Button>(R.id.login_button)
        loginBtn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val userIDText = findViewById<EditText>(R.id.et_user_id)
        val userNameText = findViewById<EditText>(R.id.et_user_name)

        val userId = userIDText.text.toString()
        val userName = userNameText.text.toString()
        val avatarUrl = "https://storage.zego.im/IMKit/avatar/avatar-0.png"

        // save userid and username
        val editor = getSharedPreferences("myPrefs", MODE_PRIVATE).edit()
        editor.putString("userID", userId)
        editor.putString("userName", userName)
        editor.apply()

        ZIMKit.connectUser(userId, userName, avatarUrl) { error: ZIMError ->
            if (error.code != ZIMErrorCode.SUCCESS) {
                val message = error.message + ": " + error.code.value()
                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                return@connectUser
            }
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent)
        }
    }


    private fun randomUserId(): String {
        val randomNum = 100 + Random().nextInt(9901)
        return randomNum.toString()
    }
}