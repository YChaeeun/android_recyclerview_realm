package com.example.recyclerrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        btn_submit_edit_txt.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
