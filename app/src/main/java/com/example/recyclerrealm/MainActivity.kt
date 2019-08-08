package com.example.recyclerrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


        // 데이터 추가 화면으로 이동 EditActivity
        btn_add_data.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        // 체크박스 선택된 아이템 삭제
        btn_delete_data.setOnClickListener {
            realm.beginTransaction()

            for (item in checkList) {
                val deleteItem = realm.where<MeasureUnit>().equalTo("unitId", item).findFirst()!!
                deleteItem.deleteFromRealm()
            }

            checkList.clear()

            realm.commitTransaction()

        }

        // 체크박스 선택된 아이템 지정된 문자열로 수정
        btn_edit_data.setOnClickListener {
            realm.beginTransaction()

            for (item in checkList) {
                val updateItem = realm.where<MeasureUnit>().equalTo("unitId", item).findFirst()!!
                updateItem.unitNameBold = "hi"
            }

            checkList.clear()


            realm.commitTransaction()

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
