package com.example.aplicaciongeneral

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplicaciongeneral.databinding.FragmentDivisasBinding

class FragmentDivisas : Fragment() {
    private var _binding: FragmentDivisasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDivisasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí puedes configurar los listeners y la lógica del fragmento
        binding.convertir.setOnClickListener {
            val monto = binding.editTextMonto.text.toString().toDoubleOrNull()
            val resultado = when (binding.spinnerDivisas.selectedItem.toString()) {
                "Soles (S/.) a Dolares ($)" -> monto?.let { it / 3.75 }
                "Dolares ($) a Soles (S/.)" -> monto?.let { it * 3.75 }
                else -> 0.0
            }
            binding.resultado.text = resultado.toString()
        }

        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        // Limpiar cualquier dato de sesión si es necesario

        // Crear un Intent para volver a MainActivity
        val intent = Intent(activity, MainActivity::class.java)
        // Limpiar la pila de actividades para que el usuario no pueda volver atrás
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        // Finalizar la actividad actual
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}