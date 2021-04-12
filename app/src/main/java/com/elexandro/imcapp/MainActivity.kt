package com.elexandro.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    private var edt_peso: EditText? = null
    private var edt_altura: EditText? = null
    private var btn_calcular: Button? = null
    private var txt_result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_peso = findViewById(R.id.pesoEDT)
        edt_altura = findViewById(R.id.alturaEDT)
        txt_result = findViewById(R.id.resultTXT)
        btn_calcular = findViewById(R.id.calcularBTN)

        setListeners()
    }

    private fun setListeners() {

        btn_calcular?.setOnClickListener {
            calcularIMC(edt_peso?.text.toString(), edt_altura?.text.toString())
        }


    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso =  peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null) {
            val imc = peso / (altura * altura)
            txt_result?.text = "Seu imd: %.{2}f".format(imc)
        }
    }
}