package com.example.a0204545_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var display: EditText

    private fun AddString(str: String){
        var oldStr:String = display.text.toString()
        var cursorPos:Int = display.selectionStart
        var leftStr:String = oldStr.substring(0, cursorPos)
        var rightStr:String = oldStr.substring(cursorPos)
        if(getString(R.string.display) == display.text.toString()){
            display.setText(str)
            display.setSelection(cursorPos + 1)
        }
        else{
            display.setText(String.format("%s%s%s",leftStr,str,rightStr))
            display.setSelection(cursorPos + 1)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById<EditText>(R.id.input)

        display.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                if(getString(R.string.display) == display.text.toString()){
                    display.setText("")
                }
            }
        })

        //Number buttons
        val zeroBTN: Button = findViewById<Button>(R.id.zeroBTN)
        val oneBTN: Button = findViewById<Button>(R.id.oneBTN)
        val twoBTN: Button = findViewById<Button>(R.id.twoBTN)
        val threeBTN: Button = findViewById<Button>(R.id.threeBTN)
        val fourBTN: Button = findViewById<Button>(R.id.fourBTN)
        val fiveBTN: Button = findViewById<Button>(R.id.fiveBTN)
        val sixBTN: Button = findViewById<Button>(R.id.sixBTN)
        val sevenBTN: Button = findViewById<Button>(R.id.sevenBTN)
        val eightBTN: Button = findViewById<Button>(R.id.eightBTN)
        val nineBTN: Button = findViewById<Button>(R.id.nineBTN)

        //Symbol buttons
        val clearBTN: Button = findViewById<Button>(R.id.clearBTN)
        val exponentBTN: Button = findViewById<Button>(R.id.exponentBTN)
        val parenthesesBTN: Button = findViewById<Button>(R.id.parenthesesBTN)
        val divideBTN: Button = findViewById<Button>(R.id.divideBTN)
        val multiplyBTN: Button = findViewById<Button>(R.id.multiplyBTN)
        val addBTN: Button = findViewById<Button>(R.id.addBTN)
        val subtractBTN: Button = findViewById<Button>(R.id.subtractBTN)
        val plusMinusBTN: Button = findViewById<Button>(R.id.plusMinusBTN)
        val pointBTN: Button = findViewById<Button>(R.id.pointBTN)
        val equalsBTN: Button = findViewById<Button>(R.id.equalsBTN)
        val backspaceBTN: ImageButton = findViewById<ImageButton>(R.id.backspaceBTN)

        //Number OnClickListeners
        zeroBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("0")
            }
        })
        oneBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("1")
            }
        })
        twoBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("2")
            }
        })
        threeBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("3")
            }
        })
        fourBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("4")
            }
        })
        fiveBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("5")
            }
        })
        sixBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("6")
            }
        })
        sevenBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("7")
            }
        })
        eightBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("8")
            }
        })
        nineBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("9")
            }
        })



        //Symbol OnClickListeners
        clearBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                display.setText("")
            }
        })
        exponentBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("^")
            }
        })
        parenthesesBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("(")
            }
        })
        divideBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("÷")
            }
        })
        multiplyBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("×")
            }
        })
        addBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("+")
            }
        })
        subtractBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("-")
            }
        })
        plusMinusBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("+/-")
            }
        })
        pointBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString(".")
            }
        })
        equalsBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("=")
            }
        })
        backspaceBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                AddString("<-")
            }
        })



    }

}