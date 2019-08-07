package com.example.recyclerrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unitList = realm.where<MeasureUnit>().findAll().sort("unitId", Sort.DESCENDING)

        // adapter 연결하기
        val recyclerAdapter = MeasureUnitAdapter(this, unitList, true)
        layout_recycler_view.adapter = recyclerAdapter

        // 변경된 데이터들을 어댑터에 적용
        unitList.addChangeListener { _ -> recyclerAdapter.notifyDataSetChanged() }

        // layoutManager 연결하기
        layout_recycler_view.layoutManager = LinearLayoutManager(this)

        // 리사이클러뷰 사이즈 고정 해제
        layout_recycler_view.setHasFixedSize(false)

        btn_add_data.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
