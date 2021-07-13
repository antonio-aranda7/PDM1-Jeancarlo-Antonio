package com.example.rfc_jeancarlo_antonio

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //****************************************************************************************->
        val calendario = Calendar.getInstance()
        val DD = calendario.get(Calendar.DAY_OF_MONTH)
        val MM = calendario.get(Calendar.MONTH)
        val AAAA = calendario.get(Calendar.YEAR)

        btnFecha.setOnClickListener {
            var datePickD =
                DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, aaaa, mm, dd ->
                    var mes = (mm + 1).toString()
                    if (mes.toInt() < 10) {
                        mes = "0" + mes
                    }
                    var dia = (dd).toString()
                    if (dia.toInt() < 10) {
                        dia = "0" + dia
                    }
                    txtViewFecha.setText("" + dia + "/" + (mes) + "/" + aaaa)
                }, AAAA, MM, DD)
            datePickD.show()
        }

        val mutableValues = mutableListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M","N", "O", "P", "Q", "R", "S", "T", "U", "V","W","X", "Y", "Z")

        btnGenerar.setOnClickListener {
            val name = txtName.text;

            val apellidoPaterno = txtApePat.text
            var apellidoVocal = SinConsonante(apellidoPaterno.toString())
            var primerVocalPat2 = ""

            if (apellidoPaterno[0].toLowerCase() == 'a' || apellidoPaterno[0].toLowerCase() == 'e' || apellidoPaterno[0].toLowerCase() == 'i' || apellidoPaterno[0].toLowerCase() == 'o' || apellidoPaterno[0].toLowerCase() == 'u') {
                primerVocalPat2 = apellidoVocal[1].toString().toUpperCase()
            } else {
                primerVocalPat2 = apellidoVocal[0].toString().toUpperCase()
            }

            val apellidoMaterno = txtApeMat.text

            val fecha = txtViewFecha.text.toString()

            if (name.length == 0 || apellidoPaterno.length == 0 || apellidoMaterno.length == 0) {
                Toast.makeText(this, "No ah ingresado todos sus datos", Toast.LENGTH_SHORT).show()
            } else {
                var primerPat1 = apellidoPaterno[0].toString().toUpperCase()
                var primerMat3 = apellidoMaterno[0].toString().toUpperCase()
                var primerNombre4 = name[0].toString().toUpperCase()
                var decada5 = fecha[8]
                var año6 = fecha[9]
                var mes7 = fecha[3]
                var mes8 = fecha[4]
                var dia9 = fecha[0]
                var dia10 = fecha[1]
                val valor11 = mutableValues.random()
                val valor12 = mutableValues.random()
                val valor13 = mutableValues.random()

                txtViewRFC.text =
                    primerPat1 + primerVocalPat2 + primerMat3 + primerNombre4 + decada5 + año6 + mes7 + mes8 + dia9 + dia10 + valor11 + valor12 + valor13
            }
        }

        btbBorrar.setOnClickListener {
            var nombre = findViewById<EditText>(R.id.txtName)
            nombre.text.clear()
            var apePat = findViewById<EditText>(R.id.txtApePat)
            apePat.text.clear()
            var apeMat = findViewById<EditText>(R.id.txtApeMat)
            apeMat.text.clear()
            var fecha = findViewById<TextView>(R.id.txtViewFecha)
            fecha.setText("Fecha")
            var rfc = findViewById<TextView>(R.id.txtViewRFC)
            rfc.setText("RFC")
        }
        //****************************************************************************************<-
    }
    //********************************************************************************************->
    //Metodo para eliminar las consonantes de los textos Nombre y Apellidos
    fun SinConsonante( text: String ): String {
        //Contruye una cadena
        val resultado = StringBuilder()
        //Recorre la cadena si hay texto
        for (char in text) {
            //Si son vocales las guarda en el arreglo
            if (!"bcdfghjklmnñpqrstvwxyz".contains(char.toLowerCase())) {

                resultado.append(char)
            }
        }
        return resultado.toString()
    }
    //********************************************************************************************<-
}


