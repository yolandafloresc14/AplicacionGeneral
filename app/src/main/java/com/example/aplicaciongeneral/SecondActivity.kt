package com.example.aplicaciongeneral

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.aplicaciongeneral.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    //Declaramos la variable binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializar el Binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtener valor de username
        val username = intent.getStringExtra("username")

        //Mostrar el mensaje de bienvenida
        binding.tvWelcome.text = "Bienvenido $username"

        //
        binding.btnDivisas.setOnClickListener {
            openDivisasFragment()
        }
    }

    private fun openDivisasFragment() {
        val fragmentDivisas = FragmentDivisas()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentDivisas)
            .addToBackStack(null)
            .commit()
    }

    fun logout() {
        // Limpiar cualquier dato de sesión si es necesario

        // Crear un Intent para volver a MainActivity
        val intent = Intent(this, MainActivity::class.java)
        // Limpiar la pila de actividades para que el usuario no pueda volver atrás
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        // Finalizar esta actividad
        finish()
    }
}