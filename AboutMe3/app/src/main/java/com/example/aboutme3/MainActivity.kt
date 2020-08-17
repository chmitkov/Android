package com.example.aboutme3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme3.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("TestUsername")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add data class
        binding.myName = myName

        //Add main layout to binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneBtn.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nick_name_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
//            nicknameText.text = binding.nickNameEdit.text
            myName?.nickname = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            doneBtn.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}