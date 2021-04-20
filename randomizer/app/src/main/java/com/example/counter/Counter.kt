package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Counter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val resetButton = findViewById<Button>(R.id.resetButton)

        val plusOne = findViewById<Button>(R.id.plus1)
        val plusTwo = findViewById<Button>(R.id.plus2)
        val plusThree = findViewById<Button>(R.id.plus3)
        val plusFour = findViewById<Button>(R.id.plus4)
        val plusFive = findViewById<Button>(R.id.plus5)
        val plusSix = findViewById<Button>(R.id.plus6)
        val plusSeven = findViewById<Button>(R.id.plus7)
        val plusEight = findViewById<Button>(R.id.plus8)
        val plusNine = findViewById<Button>(R.id.plus9)
        val plusTen = findViewById<Button>(R.id.plus10)
        val plusHundred = findViewById<Button>(R.id.plus100)
        val plusThousand = findViewById<Button>(R.id.plus1000)
        val addBtn = findViewById<Button>(R.id.addButton)
        val subBtn = findViewById<Button>(R.id.subButton)
        val numToAddOrSub =  findViewById<EditText>(R.id.NumEditTextNumber)

        val minusOne = findViewById<Button>(R.id.minus1)
        val minusTwo = findViewById<Button>(R.id.minus2)
        val minusThree = findViewById<Button>(R.id.minus3)
        val minusFour = findViewById<Button>(R.id.minus4)
        val minusFive = findViewById<Button>(R.id.minus5)
        val minusSix = findViewById<Button>(R.id.minus6)
        val minusSeven = findViewById<Button>(R.id.minus7)
        val minusEight = findViewById<Button>(R.id.minus8)
        val minusNine = findViewById<Button>(R.id.minus9)
        val minusTen = findViewById<Button>(R.id.minus10)
        val minusHundred = findViewById<Button>(R.id.minus100)
        val minusThousand = findViewById<Button>(R.id.minus1000)

        val resulText = findViewById<TextView>(R.id.resultText)

        resulText.text = 0.toString();

        resetButton.setOnClickListener{
            resulText.text = 0.toString();
        }

        addBtn.setOnClickListener(){
            var valueToBeAdded =  Integer.parseInt(numToAddOrSub.text.toString())
            var currentResultVal: Int = Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        subBtn.setOnClickListener(){
            var valueToBeAdded =  Integer.parseInt(numToAddOrSub.text.toString())
            var currentResultVal: Int = Integer.parseInt(resulText.text.toString()) - valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusOne.setOnClickListener {
            var valueToBeAdded: Int = Integer.parseInt(plusOne.getTag().toString());
            var currentResultVal: Int = Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusTwo.setOnClickListener {
            var valueToBeAdded: Int = Integer.parseInt(plusTwo.getTag().toString());
            var currentResultVal: Int = Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusThree.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusThree.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusFour.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusFour.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusFive.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusFive.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusSix.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusSix.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusSeven.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusSeven.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusEight.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusEight.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusNine.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusNine.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusTen.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusTen.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusHundred.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusHundred.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        plusThousand.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(plusThousand.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusOne.setOnClickListener {
            var valueToBeAdded: Int = Integer.parseInt(minusOne.getTag().toString());
            var currentResultVal: Int = Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusTwo.setOnClickListener {
            var valueToBeAdded: Int = Integer.parseInt(minusTwo.getTag().toString());
            var currentResultVal: Int = Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusThree.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusThree.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusFour.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusFour.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusFive.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusFive.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusSix.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusSix.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusSeven.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusSeven.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusEight.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusEight.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusNine.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusNine.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusTen.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusTen.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusHundred.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusHundred.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }

        minusThousand.setOnClickListener {
            var valueToBeAdded : Int = Integer.parseInt(minusThousand.getTag().toString());
            var currentResultVal : Int =  Integer.parseInt(resulText.text.toString()) + valueToBeAdded;
            resulText.text = currentResultVal.toString();
        }
    }
    fun increment(a: Int, b: Int): Int {
        return a + b
    }

}

