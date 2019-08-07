package com.example.recyclerrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 데이터 하드코딩
    private var unitList = arrayListOf<MeasureUnit>(
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0),
        MeasureUnit(0, 0, 0, "cc", "씨씨", "cc", 0)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adapter 연결하기
        layout_recycler_view.adapter = MeasureUnitAdapter(this, unitList)

        // layoutManager 연결하기
        layout_recycler_view.layoutManager = LinearLayoutManager(this)

        // 리사이클러뷰 사이즈 고정
        layout_recycler_view.setHasFixedSize(true)

        btn_add_data.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

    }
}
