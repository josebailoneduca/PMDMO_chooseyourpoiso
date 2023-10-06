package com.example.pickyourpoison

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity()  {
    //Referencias a elementos de la interface
    private var radioGroup: RadioGroup? = null
    private var switchImagenes: Switch? = null
    private var descripcion: TextView? = null
    private var imagen: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recogerInterface()
        agregarEventos()
    }

    private fun agregarEventos() {
        //evento de seleccion de veneno
        radioGroup?.setOnCheckedChangeListener { group, seleccion ->  actualizaDatos(seleccion) }
        //control de visibilidad de la imagen
        switchImagenes?.setOnCheckedChangeListener { boton,activo -> imagen?.visibility = if (activo) View.VISIBLE else View.INVISIBLE}
    }

    /**
     * Relacion entre boton seleccionado e imagen y descripcion
     * @param seleccion el boton seleccionado
      */
    private fun actualizaDatos(seleccion: Int) {
        //imagen
        var imagenId = when (seleccion){
            R.id.radio1-> R.drawable.socrates
            R.id.radio2->R.drawable.neron
            R.id.radio3->R.drawable.cleopatra
            R.id.radio4->R.drawable.alejandro
            else -> -1
        }
        //descripcion
        var texto=""
        if (imagenId!=-1){
            texto = when (seleccion){
                R.id.radio1-> getString(R.string.etiqueta1)
                R.id.radio2-> getString(R.string.etiqueta2)
                R.id.radio3-> getString(R.string.etiqueta3)
                R.id.radio4-> getString(R.string.etiqueta4)
                else -> ""
            }
        }
        //actualizacion en layout
        if (imagenId!=-1) imagen?.setImageResource(imagenId)
        descripcion?.setText(texto)
    }

    /**
     * Recoge referencias a los objetos de la interface
     */
    private fun recogerInterface() {
        radioGroup = findViewById(R.id.radioGroup)
        switchImagenes = findViewById(R.id.switchImagenes)
        descripcion = findViewById(R.id.descripcion)
        imagen = findViewById(R.id.imagen)
    }
}
