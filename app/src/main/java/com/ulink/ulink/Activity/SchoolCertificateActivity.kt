package com.ulink.ulink.Activity

import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ulink.ulink.R
import com.ulink.ulink.utils.DialogBuilder
import kotlinx.android.synthetic.main.activity_school_certificate.*

class SchoolCertificateActivity : AppCompatActivity() {

    var requestSent = false
    var validate = false
    var activated1 = false
    var activated2 = false




    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_certificate)


        tv_emailcertificateinfo.text = Html.fromHtml(getString(R.string.school_certificate_info), Html.FROM_HTML_MODE_LEGACY)

        btn_back.setOnClickListener { finish() }

//      기본 다이얼로그

        et_email.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                btn_request.setBackgroundResource(R.drawable.btn_request_active)
                btn_request.setTextColor(resources.getColor(R.color.white))
                activated1 = true
            }
        }

        et_code.setOnFocusChangeListener { v, hasFocus ->
            if (requestSent) {
                btn_ok.setBackgroundResource(R.drawable.btn_request_active)
                btn_ok.setTextColor(resources.getColor(R.color.white))
                activated2 = true
            }
        }


        btn_request.setOnClickListener {
            if (activated1) {
                DialogBuilder().apply {
                    build(this@SchoolCertificateActivity)
                    setContent(getString(R.string.school_certificate_codesent))
                    setClickListener {
                        dismiss()
                    }
                    show()
                }
//                TODO 여기서 서버에 인증코드 요청!
                startTimer()
                requestSent = true
            }
        }


        btn_ok.setOnClickListener {
            if (activated2) {
//              TODO 서버랑 코드 같은지 확인
                val serverPass = 123
                if (et_code.text.toString() == serverPass.toString()){
                    DialogBuilder().apply {
                        build(this@SchoolCertificateActivity)
                        setContent(getString(R.string.school_certificate_ok))
                        setButtonText("홈으로 가기")
                        setClickListener {
                            dismiss()
                            finish()
                        }
                        show()
                    }
                } else{
                    DialogBuilder().apply {
                        build(this@SchoolCertificateActivity)
                        setContent(getString(R.string.school_certificate_wrongcode))
                        setClickListener {
                            dismiss()
                        }
                        show()
                    }
                }
            }
        }

        tv_codeerror.setOnClickListener {
            DialogBuilder().apply {
                build(this@SchoolCertificateActivity)
                setContent(getString(R.string.school_certificate_checkspam))
                setClickListener {
                    dismiss()
                }
                show()
            }
        }
    }

    fun startTimer() {
        validate = true
        object : CountDownTimer(180 * 1000, 1000) {
            override fun onFinish() {
                validate = false
            }

            override fun onTick(millisUntilFinished: Long) {
                val count = millisUntilFinished / 1000
                if (count - count / 60 * 60 >= 10) {
                    tv_time.text = (count / 60).toString() + ":" + (count - count / 60 * 60)
                } else {
                    tv_time.text = (count / 60).toString() + ":0" + (count - count / 60 * 60)
                }
            }
        }.start()
    }


}