package com.example.recyclerrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 데이터 하드코딩
    private var unitList = arrayListOf<MeasureUnit>(
        MeasureUnit("cc", "씨씨"),
        MeasureUnit("ml", "밀리미터"),
        MeasureUnit("L", "리터"),
        MeasureUnit("mg", "밀리그램"),
        MeasureUnit("kg", "킬로그램"),
        MeasureUnit("큰술", "tbsp"),
        MeasureUnit("작은술", "tsp"),
        MeasureUnit("컵", "cup"),
        MeasureUnit("밥숟갈", "15cc"),
        MeasureUnit("베라스푼", "5cc"),
        MeasureUnit("물뚜껑", "7cc"),
        MeasureUnit("소주잔", "50ml")
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

    }
}
