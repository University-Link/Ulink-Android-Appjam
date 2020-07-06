package com.example.ulink.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ulink.CalendarRecycler.*
import com.example.ulink.R
import com.example.ulink.ScheduleActivity
import kotlinx.android.synthetic.main.fragment_calendar.*
import kotlinx.android.synthetic.main.fragment_class.*

class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_today.text = nowDay().toString()

        var now_CalendarData = calendarDataInit(tv_month) // now_month

        calendar_viewPager.setUserInputEnabled(false)
        calendar_viewPager.adapter = CalendarAdapter(view.context, now_CalendarData)

        btn_left_month.setOnClickListener(){
            now_CalendarData = calendarPrevMonth(tv_month, now_CalendarData.month, now_CalendarData.year) // prev_month
            calendar_viewPager.adapter = CalendarAdapter(view.context, now_CalendarData)
        }

        btn_right_month.setOnClickListener() {
            now_CalendarData = calendarNextMonth(tv_month, now_CalendarData.month, now_CalendarData.year) // next_month
            calendar_viewPager.adapter = CalendarAdapter(view.context, now_CalendarData)
        }

        btn_today.setOnClickListener() {
            now_CalendarData = calendarDataInit(tv_month) // today
            calendar_viewPager.adapter = CalendarAdapter(view.context, now_CalendarData)
        }

        btn_schedule.setOnClickListener(){
            val intent = Intent(activity, ScheduleActivity::class.java)
            startActivity(intent)
        }
    }
}