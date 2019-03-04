package com.example.dell.jpushdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import cn.jpush.android.api.JPushInterface

class MainActivity : AppCompatActivity() {


    companion object {
        var isForeground = false
    }

    lateinit var mRegId:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRegId=findViewById<TextView>(R.id.tv_reg_id)
        init() //初始化
    }


    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private fun init() {
        //JPushInterface.init(applicationContext)

        val rid = JPushInterface.getRegistrationID(applicationContext)
        if (!rid.isEmpty()) {
            mRegId.setText("RegId:$rid")
        } else {
            Toast.makeText(this, "Get registration fail, JPush init failed!", Toast.LENGTH_SHORT).show()
        }
    }
}
