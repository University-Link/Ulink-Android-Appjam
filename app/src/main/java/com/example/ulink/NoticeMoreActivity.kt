package com.example.ulink

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ulink.NoticeRecycler.ScheduleNoticeMoreAdapter
import com.example.ulink.ScheduleRecycler.ScheduleItemData
import com.example.ulink.ScheduleRecycler.SchedulePopupAdapter
import kotlinx.android.synthetic.main.activity_notice.*
import kotlinx.android.synthetic.main.activity_notice_more.*
import kotlinx.android.synthetic.main.item_notice_more.*
import kotlinx.android.synthetic.main.toolbar_notice_more.*
import kotlinx.android.synthetic.main.toolbar_notice_more.btn_back
import java.util.ArrayList

class NoticeMoreActivity : AppCompatActivity() {

    lateinit var rvMoreAdapter : ScheduleNoticeMoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_more)

        rvMoreAdapter = ScheduleNoticeMoreAdapter(this)
        rv_notice_more.adapter = rvMoreAdapter

        var toolbarTitle = intent.getStringExtra("category")
        if (toolbarTitle != "")
            tv_notice_more_toolbar.text = toolbarTitle + "공지"

        var item : ArrayList<ScheduleItemData> = intent.getParcelableArrayListExtra("rvData")

        rvMoreAdapter.datas = item
        rvMoreAdapter.notifyDataSetChanged()

        Log.d("item", rvMoreAdapter.datas.size.toString())

        rvMoreAdapter.setScheduleItemClickListener(object: ScheduleNoticeMoreAdapter.ScheduleNoticeClickListener{
            override fun onClick(view: View, position:Int){
                val intent = Intent(view.context, ScheduleNoticeActivity::class.java)
                intent.putExtra("scheduleItemData", rvMoreAdapter.datas[position])
                view.context.startActivity(intent)
            }
        })

        btn_back.setOnClickListener() {
            finish()
        }
    }
}