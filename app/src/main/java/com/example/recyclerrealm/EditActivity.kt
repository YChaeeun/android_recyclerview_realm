package com.example.recyclerrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    private val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        btn_submit_edit_txt.setOnClickListener {
            insertData()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    // 데이터 추가하기
    private fun insertData() {
        realm.beginTransaction()

        val newItem = realm.createObject<MeasureUnit>(nextId())
        newItem.unitNameBold = edit_txt_name_bold.text.toString()
        newItem.unitNameSoft = edit_txt_name_bold.text.toString()

        realm.commitTransaction()
    }

    private fun nextId() : Int {
        val maxId = realm.where<MeasureUnit>().max("unitId")
        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }
}
