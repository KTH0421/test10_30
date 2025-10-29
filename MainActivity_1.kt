//계산기앱

package com.example.ys08a_gridcalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var edit1: EditText
    lateinit var edit2: EditText

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var result: TextView

    var numBtn = ArrayList<Button>(10)
    var numBtnId = arrayOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9)

    var i : Int = 0;        //반복횟수

    var num1:String?=null
    var num2:String?=null
    var rr:Int ?= 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //title = "Grid Layout 활용 계산기"

        //객체 초기화
        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)

        btnAdd = findViewById<Button>(R.id.btnAdd)
        btnSub = findViewById<Button>(R.id.btnSub)
        btnMul = findViewById<Button>(R.id.btnMul)
        btnDiv = findViewById<Button>(R.id.btnDiv)

        result = findViewById<TextView>(R.id.result)

        //숫자버튼 추가
        for (i in 0 ..9 step 1) {
            numBtn.add(findViewById<Button>(numBtnId[i]))
        }

        for(i in 0..numBtn.size -1 step 1){
            numBtn[i].setOnClickListener{
                if(edit1.isFocused == true){
                    num1 = edit1.text.toString() + numBtn[i].text.toString()
                    edit1.setText(num1)

                }
                else if(edit2.isFocused==true){
                    num2 = edit2.text.toString() + numBtn[i].text.toString()
                    edit2.setText(num2)
                }
                else{
                    Toast.makeText(applicationContext, "숫자 1이나 숫자 2를 터치하세요 좀", Toast.LENGTH_SHORT).show()
                }
            }   //숫자버튼 리스너
        }   //for문




        btnAdd.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            rr = Integer.parseInt(num1) + Integer.parseInt(num2)
            result.text = "계산결과 : " + rr.toString()
        }

        btnSub.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            rr = Integer.parseInt(num1) - Integer.parseInt(num2)
            result.text = "계산결과 : " + rr.toString()
        }

        btnMul.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            rr = Integer.parseInt(num1) * Integer.parseInt(num2)
            result.text = "계산결과 : " + rr.toString()
        }

        btnDiv.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            rr = Integer.parseInt(num1) / Integer.parseInt(num2)
            result.text = "계산결과 : " + rr.toString()
        }



    } //onCreate
}//class