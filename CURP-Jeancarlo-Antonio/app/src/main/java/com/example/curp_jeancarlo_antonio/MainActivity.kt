package com.example.curp_jeancarlo_antonio

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            var datePickD = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, aaaa, mm, dd ->
                var mes = (mm+1).toString()
                if (mes.toInt()<10){
                    mes = "0" + mes
                }
                var dia = (dd).toString()
                if (dia.toInt()<10){
                    dia = "0" + dia
                }
                txtViewFecha.setText(""+ dia + "/" + (mes) + "/" + aaaa)},AAAA, MM, DD)
            datePickD.show()
        }

        var genero = ""

        radioBtbGroupGenero.setOnCheckedChangeListener { group, i ->
            if (i == R.id.radioBtnH)
                genero = radioBtnH.text[0].toString()
            Toast.makeText(this,genero,Toast.LENGTH_SHORT).show()

            if (i == R.id.radioBtnM)
                genero = radioBtnM.text[0].toString()
            Toast.makeText(this,genero,Toast.LENGTH_SHORT).show()
        }

        var arrayEstados = arrayOf("AS-Aguascalientes","BC-Baja California","BS-Baja California Sur","CC-Campeche","CL-Coahuila","CM-Colima", "CS-Chiapas","CH-Chihuahua","DF-Distrito Federal","DG-Durango","GT-Guanajuato","GR-Guerrero","HG-Hidalgo","JC-Jalisco","MC-México","MN-Michoacán","MS-Morelos","NT-Nayarit", "NL-Nuevo León","OC-Oaxaca","PL-Puebla","QT-Querétaro","QR-Quintana Roo","SP-San Luis Potosí","SL-Sinaloa","SR-Sonora","TC-Tabasco","TS-Tamaulipas", "TL-Tlaxcala","VZ-Veracruz","YN-Yucatan","ZS-Zacatecas","NE-Nacido en el Extrenjero")

        val arrayAdapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,arrayEstados)
        spinnerEstados.adapter = arrayAdapter

        spinnerEstados.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val estado = (arrayEstados[position])
                txtViewEstados.setText(estado)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val mutableValues = mutableListOf("0","1","2","3","4","5","6","7","8","9")

        btnGenerar.setOnClickListener {
            val name = txtName.text;
            val consonanteNombre = SinVocal(name.toString())
            var segundaConsonateNombre16 = ""

            if (name[0].toLowerCase() == 'a'|| name[0].toLowerCase() == 'e'|| name[0].toLowerCase() == 'i'|| name[0].toLowerCase() == 'o'|| name[0].toLowerCase() == 'u' ){
                segundaConsonateNombre16 = consonanteNombre[0].toString().toUpperCase()
            }
            else{
                segundaConsonateNombre16 = consonanteNombre[1].toString().toUpperCase()
            }

            val apellidoPaterno = txtApePat.text
            var apellidoVocal = SinConsonante(apellidoPaterno.toString())
            var primerVocalPat2 = ""

            if (apellidoPaterno[0].toLowerCase() == 'a'|| apellidoPaterno[0].toLowerCase() == 'e'|| apellidoPaterno[0].toLowerCase() == 'i'|| apellidoPaterno[0].toLowerCase() == 'o'|| apellidoPaterno[0].toLowerCase() == 'u' ){
                primerVocalPat2 = apellidoVocal[1].toString().toUpperCase()
            }
            else{
                primerVocalPat2 = apellidoVocal[0].toString().toUpperCase()
            }

            val consonantePaterno = SinVocal(apellidoPaterno.toString())
            var segundaConsonatePat14 = ""

            if (apellidoPaterno[0].toLowerCase() == 'a'|| apellidoPaterno[0].toLowerCase() == 'e'|| apellidoPaterno[0].toLowerCase() == 'i'|| apellidoPaterno[0].toLowerCase() == 'o'|| apellidoPaterno[0].toLowerCase() == 'u' ){
                segundaConsonatePat14 = consonantePaterno[0].toString().toUpperCase()
            }
            else{
                segundaConsonatePat14 = consonantePaterno[1].toString().toUpperCase()
            }

            val apellidoMaterno = txtApeMat.text
            val consonanteMaterno = SinVocal(apellidoMaterno.toString())
            var segundaConsonateMat15 = ""
            if (apellidoMaterno[0].toLowerCase() == 'a'|| apellidoMaterno[0].toLowerCase() == 'e'|| apellidoMaterno[0].toLowerCase() == 'i'|| apellidoMaterno[0].toLowerCase() == 'o'|| apellidoMaterno[0].toLowerCase() == 'u' ){
                segundaConsonateMat15 = consonanteMaterno[0].toString().toUpperCase()
            }
            else{
                segundaConsonateMat15 = consonanteMaterno[1].toString().toUpperCase()
            }

            val fecha = txtViewFecha.text.toString()

            if(name.length == 0 || apellidoPaterno.length == 0 || apellidoMaterno.length == 0){
                Toast.makeText(this,"No ah ingresado todos sus datos",Toast.LENGTH_SHORT).show()
            }
            else{
                var primerPat1 = apellidoPaterno[0].toString().toUpperCase()
                var primerMat3 = apellidoMaterno[0].toString().toUpperCase()
                var primerNombre4 = name[0].toString().toUpperCase()
                var decada5 = fecha[8]
                var año6 = fecha[9]
                var mes7 = fecha[3]
                var mes8 = fecha[4]
                var dia9 = fecha[0]
                var dia10 = fecha[1]
                var genero11 = genero
                var estado12 = txtViewEstados.text[0]
                var estado13 = txtViewEstados.text[1]
                val valor17 = mutableValues.random()
                val valor18 = mutableValues.random()

                txtViewCURP.text = primerPat1 + primerVocalPat2 + primerMat3 + primerNombre4 + decada5 + año6 + mes7 + mes8 + dia9 + dia10 + genero11 + estado12 + estado13 + segundaConsonatePat14 + segundaConsonateMat15 + segundaConsonateNombre16 + valor17 + valor18
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
            var estado = findViewById<TextView>(R.id.txtViewEstados)
            estado.setText("Estado")
            var curp = findViewById<TextView>(R.id.txtViewCURP)
            curp.setText("CURP")
        }
        //****************************************************************************************<-
    }

    //*****************************************************************************
    fun SinConsonante( text: String ): String {
        val resultado = StringBuilder()
        for ( char in text ) {
            if ( !"bcdfghjklmnñpqrstvwxyz".contains(char.toLowerCase()) ) {

                resultado.append( char )
            }
        }
        return resultado.toString()
    }

    fun SinVocal( text: String ): String {
        val resultado = StringBuilder()
        for ( char in text ) {
            if ( !"aeiou".contains(char.toLowerCase()) ) {

                resultado.append( char )
            }
        }
        return resultado.toString()
    }
    //********************************************************************************************<-
}
