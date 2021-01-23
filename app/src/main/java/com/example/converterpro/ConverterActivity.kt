package com.example.converterpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ConverterActivity : AppCompatActivity()
{
    private var op: Int = 0
    private var pos1: Int = 0
    private var pos2: Int = 0
    //Array Adapter is important
    private var arrayAdapter: ArrayAdapter<String>? = null

    private var lengthArray = arrayOf("Meter","Centi Meter","Inches","Feet")
    private var currencyArray = arrayOf("Rupee","Dollar")
    private var tempuratureArray = arrayOf("Celcius","Fahrenheit")

    //nullable variable of require type
    private var spinner1 : Spinner? = null
    private var spinner2 : Spinner? = null
    private var textinput : EditText? = null
    private var textoutput : TextView? = null

    private var button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)

        textinput = findViewById(R.id.textinput)
        textoutput = findViewById(R.id.textoutput)

        //get intent
        op = intent.getIntExtra("option", -1)

        when (op) {
            //op = 1 -> length converter
            1 -> {
                arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lengthArray)
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter

                //onItem selected listener for spinner1
                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@ConverterActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                    }

                }

                //onItem selected listener for spinner2
                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@ConverterActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                    }
                }
            }

            //op = 2 for currency
            2 -> {
                arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencyArray)
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter

                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@ConverterActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                    }

                }
                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@ConverterActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                    }
                }
            }

            //op = 3 for tempurature
            3 -> {
                arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tempuratureArray)
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter

                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@ConverterActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                    }

                }
                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@ConverterActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        button = findViewById(R.id.button)

        //converter button on click listener and selection of spinner1 and spinner2 output value in textoutput
        button?.setOnClickListener {

            //get data of user entered
            val text1 = textinput?.text.toString().toDoubleOrNull()

            if(text1==null)
            {
                Toast.makeText(this, "Enter Value", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (op == 1) {
                if (pos1 == 0) //meter
                {
                    if (pos2 == 0) //meter
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 1) //Centi Meter
                    {
                        textoutput?.text = (text1 * 100).toString()
                    } else if (pos2 == 2)    //Inches
                    {
                        textoutput?.text = (text1 * 39.3701).toString()
                    } else if (pos2 == 3)    //Feet
                    {
                        textoutput?.text = (text1 * 3.28084).toString()
                    }
                } else if (pos1 == 1) //Centi Meter
                {
                    if (pos2 == 0) //meter
                    {
                        textoutput?.text = (text1 / 100).toString()
                    } else if (pos2 == 1) //Centi Meter
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 2)    //Inches
                    {
                        textoutput?.text = (text1 * 0.393701).toString()
                    } else if (pos2 == 3)    //Feet
                    {
                        textoutput?.text = (text1 * 0.0328084).toString()
                    }
                } else if (pos1 == 2)    //Inches
                {
                    if (pos2 == 0) //meter
                    {
                        textoutput?.text = (text1 * 0.0254).toString()
                    } else if (pos2 == 1) //Centi Meter
                    {
                        textoutput?.text = (text1 * 2.54).toString()
                    } else if (pos2 == 2)    //Inches
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 3)    //Feet
                    {
                        textoutput?.text = (text1 * 0.08333333).toString()
                    }
                } else if (pos1 == 3)    //Feet
                {
                    if (pos2 == 0) //meter
                    {
                        textoutput?.text = (text1 * 0.3048).toString()
                    } else if (pos2 == 1) //Centi Meter
                    {
                        textoutput?.text = (text1 * 30.48).toString()
                    } else if (pos2 == 2)    //Inches
                    {
                        textoutput?.text = (text1 * 12).toString()
                    } else if (pos2 == 3)    //Feet
                    {
                        textoutput?.text = (text1).toString()
                    }
                }
            }

            else if (op == 2) {
                //we assumed here 1 dollar = 70 ruppe
                if (pos1 == 0) //Rupee
                {
                    if (pos2 == 0) //Rupee
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 1)    //Dollar
                    {
                        textoutput?.text = (text1 / 70).toString()
                    }
                } else if (pos1 == 1)    //Dollar
                {
                    if (pos2 == 0) //Rupee
                    {
                        textoutput?.text = (text1 * 70).toString()
                    } else if (pos2 == 1)    //Dollar
                    {
                        textoutput?.text = (text1).toString()
                    }
                }
            }

            else if (op == 3) {
                if (pos1 == 0) //Celcius
                {
                    if (pos2 == 0) //Celcius
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 1)    //Fahrenheit
                    {
                        textoutput?.text = ((1.8) * text1 + 32).toString()
                    }
                } else if (pos1 == 1)    //Fahrenheit
                {
                    if (pos2 == 0) //Celcius
                    {
                        textoutput?.text = (((text1 - 32) * 5) / 9).toString()
                    } else if (pos2 == 1)    //Fahrenheit
                    {
                        textoutput?.text = (text1).toString()
                    }
                }
            }
        }
    }
}