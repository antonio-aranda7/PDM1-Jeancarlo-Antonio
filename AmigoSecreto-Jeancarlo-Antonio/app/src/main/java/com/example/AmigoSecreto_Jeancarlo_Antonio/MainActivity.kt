package com.example.AmigoSecreto_Jeancarlo_Antonio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Collections.shuffle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //****************************************************************************************->
        val Amigo = txtAmigo.text;
        var listaAmigos = findViewById<ListView>(R.id.listViewAmigos);
        var arrayAdapter: ArrayAdapter<*>
        val cadenaAmigos =  mutableListOf<String>();
        var btnAgregar = findViewById<Button>(R.id.btnAgregar);

        btnAgregar.setOnClickListener {
            cadenaAmigos.add(Amigo.toString())
            arrayAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cadenaAmigos
            )
            listaAmigos.adapter = arrayAdapter;
            arrayAdapter.notifyDataSetChanged();

            var nombre = findViewById<EditText>(R.id.txtAmigo)
            nombre.text.clear()
        }

        var secreto = findViewById<TextView>(R.id.txtSecreto)

        btnSortear.setOnClickListener {
             if (cadenaAmigos.size <= 2){
                 secreto.setText("Agregue más amigos");
             }
            else{
                 var amigoSecreto = mutableListOf<String>(cadenaAmigos.toString());
                 shuffle(cadenaAmigos);
                 if (amigoSecreto.toString() == cadenaAmigos.toString()){
                     btnSortear.performClick();
                 }
                 else{
                     secreto.setText(cadenaAmigos.toString());
                 }
             }
        }
        //****************************************************************************************<-
    }
}
