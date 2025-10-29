//키오스크앱

package com.example.ysa05_kioskapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var start:Switch
    lateinit var menuLayout:LinearLayout

    lateinit var m1:RadioButton
    lateinit var m2:RadioButton
    lateinit var m3:RadioButton
    lateinit var m4:RadioButton
    lateinit var m5:RadioButton
    lateinit var m6:RadioButton

    lateinit var count:EditText
    lateinit var orderBtn:Button
    lateinit var result: TextView

    var c : Int? = 0
    var r : Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        start = findViewById<Switch>(R.id.start)
        menuLayout = findViewById<LinearLayout>(R.id.menuLayout)
        m1 = findViewById<RadioButton>(R.id.m1)
        m2 = findViewById<RadioButton>(R.id.m2)
        m3 = findViewById<RadioButton>(R.id.m3)
        m4 = findViewById<RadioButton>(R.id.m4)
        m5 = findViewById<RadioButton>(R.id.m5)
        m6 = findViewById<RadioButton>(R.id.m6)
        count = findViewById<EditText>(R.id.count)
        orderBtn = findViewById<Button>(R.id.orderBtn)
        result = findViewById<TextView>(R.id.result)

        start.setOnCheckedChangeListener{compoundButton,b ->
            if (start.isChecked == true) {
                menuLayout.visibility = android.view.View.VISIBLE;
            } else{
                menuLayout.visibility = android.view.View.INVISIBLE;
            }
        }//스위치로 메뉴 보이고 안보이고 조작하는 메서드

        m1.setOnClickListener{
            m2.isChecked=false
            m3.isChecked=false
            m4.isChecked=false
            m5.isChecked=false
        }

        m2.setOnClickListener{
            m1.isChecked=false
            m3.isChecked=false
            m4.isChecked=false
            m5.isChecked=false
        }

        m3.setOnClickListener{
            m1.isChecked=false
            m2.isChecked=false
            m4.isChecked=false
            m5.isChecked=false
        }

        m4.setOnClickListener{
            m1.isChecked=false
            m2.isChecked=false
            m3.isChecked=false
            m5.isChecked=false
        }

        m5.setOnClickListener{
            m1.isChecked=false
            m2.isChecked=false
            m3.isChecked=false
            m4.isChecked=false
        }

        orderBtn.setOnClickListener{
            c = Integer.parseInt(count.text.toString())

            if (m1.isChecked == true)
                r = c!! *500
            else if (m2.isChecked==true)
                r = c!! *600
            else if (m3.isChecked==true)
                r = c!! *700
            else if (m4.isChecked==true)
                r = c!! *800
            else if (m5.isChecked==true)
                r = c!! *900
            else if (m6.isChecked==true)
                r = c!! *1000

            result.text="총금액 : "+r.toString()



        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }//onCreate
}//MainActivity