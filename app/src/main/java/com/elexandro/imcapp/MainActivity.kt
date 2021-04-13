package com.elexandro.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    private var edtPeso: EditText? = null
    private var edtAlt: EditText? = null
    private var btnCalc: Button? = null
    private var txtResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPeso = findViewById(R.id.pesoEDT)
        edtAlt = findViewById(R.id.alturaEDT)
        txtResult = findViewById(R.id.resultTXT)
        btnCalc = findViewById(R.id.calcularBTN)

        setListeners()
    }

    private fun setListeners() {

        //edtAlt?.doAfterTextChanged { text ->
         //   Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        //}
        btnCalc?.setOnClickListener {
            //Toast.makeText(this, edtAlt?.text.toString(), Toast.LENGTH_SHORT).show()
            calcularIMC(edtPeso?.text.toString(), edtAlt?.text.toString())
        }

    }

    private fun calcularIMC(peso: String, alt: String) {
        val peso =  peso.toFloatOrNull()
        val alt = alt.toFloatOrNull()
        if(peso != null && alt != null) {
            val imc = peso / (alt * alt)
            txtResult?.text = "Seu imd: %.${2}f".format(imc)
            //txtResult?.text = imc.toString()
            Toast.makeText(this, imc.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}