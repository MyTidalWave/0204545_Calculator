package com.example.a0204545_calculator

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import org.mariuszgromada.math.mxparser.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.text.buildSpannedString
import android.text.SpannableStringBuilder
import android.util.Log

private val TAG = "MainActivity"
private val TEXT= "TEXT_CONTENT"


class MainActivity : AppCompatActivity() {


    lateinit var display: EditText

    fun addString(str: String){
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
                addString("0")
            }
        })
        oneBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("1")
            }
        })
        twoBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("2")
            }
        })
        threeBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("3")
            }
        })
        fourBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("4")
            }
        })
        fiveBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("5")
            }
        })
        sixBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("6")
            }
        })
        sevenBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("7")
            }
        })
        eightBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("8")
            }
        })
        nineBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("9")
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
                addString("^")
            }
        })
        parenthesesBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var cursorPos:Int = display.selectionStart
                var openPar:Int = 0
                var closedPar:Int = 0
                var texLen:Int = display.text.length

                for(i in 0 until cursorPos)
                {
                    if(display.text.toString().substring(i, i+1) == "("){
                        openPar += 1
                    }
                    if(display.text.toString().substring(i, i+1) == ")"){
                        closedPar += 1
                    }
                }

                if(openPar == closedPar || display.text.toString().substring(texLen-1, texLen) == "(")
                {
                    addString("(")
                }
                else if(closedPar < openPar && display.text.toString().substring(texLen-1, texLen) != "(")
                {
                    addString(")")
                }
                display.setSelection(cursorPos + 1)

            }
        })
        divideBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("÷")
            }
        })
        multiplyBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("×")
            }
        })
        addBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("+")
            }
        })
        subtractBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString("-")
            }
        })
        plusMinusBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                //addString("+/-")
                var cursorPos:Int = display.selectionStart
                var textLen:Int = display.text.length
                var minus:String = "-"

                if(cursorPos != 0 && textLen != 0){
                    //var selection:SpannableStringBuilder = display.text as SpannableStringBuilder
                    //selection.replace(cursorPos-1,cursorPos,"")
                    //display.setText(selection)
                    //display.setSelection(cursorPos - 1)
                    display.setText(minus + display.text )
                    display.setSelection(cursorPos + 1)
                }
            }
        })
        pointBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                addString(".")
            }
        })
        equalsBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var userExp:String = display.text.toString()

                userExp = userExp.replace("÷","/")
                userExp = userExp.replace("×","*")

                //var exp = Expression(userExp)
                var exp:Expression = Expression(userExp)

                var result:String = exp.calculate().toString()

                display.setText(result)
                display.setSelection(result.length)

            }
        })
        backspaceBTN.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var cursorPos:Int = display.selectionStart
                var textLen:Int = display.text.length


                if(cursorPos != 0 && textLen != 0){
                    var selection:SpannableStringBuilder = display.text as SpannableStringBuilder
                    selection.replace(cursorPos-1,cursorPos,"")
                    display.setText(selection)
                    display.setSelection(cursorPos - 1)
                }
            }
        })



    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        //val savedString = savedInstanceState.getString(TEXT)
        //display?.setText(savedString)
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        //outState.putString(TEXT, display?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}