package com.example.ulink

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ulink.ScheduleRecycler.ScheduleItemData
import kotlinx.android.synthetic.main.activity_class_notice.*
import kotlinx.android.synthetic.main.calendar_item.*
import kotlinx.android.synthetic.main.toolbar_schedulenotice.*

class ScheduleNoticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_notice)

        var scheduleItemData = intent.getParcelableExtra<ScheduleItemData>("scheduleItemData")
        tv_schedulenotice_toolbar.text = scheduleItemData.category+"공지"

        if(scheduleItemData.startTime!="" || scheduleItemData.endTime!="")
            tv_schedule_notice_time_content.text = scheduleItemData.startTime + " ~ " + scheduleItemData.endTime
        else
            tv_schedule_notice_time_content.text = "시간 정보 없음"

        var scheduleDate = scheduleItemData.date.split("-")
        tv_schedule_notice_date_content.text = scheduleDate[0]+"년 "+scheduleDate[1]+"월 "+scheduleDate[2]+"일"

        tv_schedule_notice_title.text = scheduleItemData.content

        btn_back.setOnClickListener() {
            finish()
        }

        btn_edit.setOnClickListener() {
            val intent = Intent(this, ScheduleActivity::class.java)
            intent.putExtra("category", tv_schedulenotice_toolbar.text.toString())
            intent.putExtra("title", tv_schedule_notice_title.text.toString())
            intent.putExtra("date", tv_schedule_notice_date_content.text.toString())
            intent.putExtra("memo", tv_schedule_notice_memo_content.text.toString())
            intent.putExtra("time", tv_schedule_notice_time.text.toString())

//            val intent = intent
//            val category = intent.getStringExtra("category")
//            val title = intent.getStringExtra("title")
//            val date = intent.getStringExtra("date")
//            val memo = intent.getStringExtra("memo")
//            val startTime = intent.getStringExtra("startTime")
//            val endTime = intent.getStringExtra("endTime")
            startActivity(intent)
        }
    }
}

