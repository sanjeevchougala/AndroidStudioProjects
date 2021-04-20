package com.FunOFunTime.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var billAmt = findViewById<EditText>(R.id.totalAmountEditText)
        var tip = findViewById<EditText>(R.id.tipPercentageEditText)
        var totalAmtWithTips = findViewById<TextView>(R.id.totalAmountWithTipsTextView)
        totalAmtWithTips.visibility = View.INVISIBLE
        var btnCalculate = findViewById<Button>(R.id.calculateButton)

        btnCalculate.setOnClickListener(){
            val billAmount =  billAmt.text.toString().toDouble()
            val tipsPercent = tip.text.toString().toDouble()
            val tipsAmount = billAmount * tipsPercent /100
            val totalAmount = billAmount + tipsAmount
            totalAmtWithTips.visibility = View.VISIBLE

            totalAmtWithTips.text = "Tip: ${formatAmt(tipsAmount)} Total is : ${formatAmt(totalAmount)}"
        }
    }

    private fun formatAmt(amt: Double):String{
        return "$" + String.format("%.2f", amt)
    }

}