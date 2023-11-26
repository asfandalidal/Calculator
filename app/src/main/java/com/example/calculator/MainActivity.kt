package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    // Declare calSc as a property of the class
    private lateinit var calSc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calSc = findViewById<TextView>(R.id.calculatorView)
        val button0 = findViewById<Button>(R.id.btn0)
        val button1 = findViewById<Button>(R.id.btn1)
        val button2=findViewById<Button>(R.id.btn2)
        val button3=findViewById<Button>(R.id.btn3)
        val button4=findViewById<Button>(R.id.btn4)
        val button5=findViewById<Button>(R.id.btn5)
        val button6=findViewById<Button>(R.id.btn6)
        val button7=findViewById<Button>(R.id.btn7)
        val button8=findViewById<Button>(R.id.btn8)
        val button9=findViewById<Button>(R.id.btn9)
        val buttonMulti=findViewById<Button>(R.id.btnmulti)
        val buttondiv=findViewById<Button>(R.id.btndiv)
        val buttonsum=findViewById<Button>(R.id.btnsum)
        val buttonsub=findViewById<Button>(R.id.btnminus)
        val buttonmodulo=findViewById<Button>(R.id.btnmodulo)
        val buttonclear=findViewById<Button>(R.id.btnClear)
        val buttonresult=findViewById<Button>(R.id.btnResult)
        val buttondot=findViewById<Button>(R.id.btndot)
        clickToView(button0)
        clickToView(button1)
        clickToView(button2)
        clickToView(button3)
        clickToView(button4)
        clickToView(button5)
        clickToView(button6)
        clickToView(button7)
        clickToView(button8)
        clickToView(button9)
        clickToView(buttonMulti)
        clickToView(buttondiv)
        clickToView(buttondot)
        clickToView(buttonsub)
        clickToView(buttonsum)
        clickToView(buttonmodulo)
        buttonclear.setOnClickListener()
        {
            calSc.text=""
        }
        buttonresult.setOnClickListener {
            try{
            try {
                // Get the text from calSc and convert it to a string
                val answerStr = calSc.text.toString()
                // Convert the string representation of the calculation result to a Double
                if (answerStr.contains(".")) {
                    val result = ExpressionBuilder(answerStr).build().evaluate()
                    val formatedResult = String.format("%.2f", result)
                    calSc.text = formatedResult.toString()
                } else {
                    val result = ExpressionBuilder(answerStr).build().evaluate()
                    val resultInt = result.toInt()
                    // Set the text of calSc to the result converted back to a string
                    calSc.text = resultInt.toString()
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
        }
            catch(e:ArithmeticException)
            {
                calSc.text="Math error"
            }
        }
    }
    private fun clickToView(button : Button)
    {
        button.setOnClickListener() {
            calSc.text = "${calSc.text}${button.text}"
        }
    }
}