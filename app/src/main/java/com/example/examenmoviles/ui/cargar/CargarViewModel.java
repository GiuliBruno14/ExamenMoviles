package com.example.examenmoviles.ui.cargar;

import androidx.lifecycle.ViewModel;

import com.example.examenmoviles.MainActivity;
import com.example.examenmoviles.modelo.Persona;

public class CargarViewModel extends ViewModel {


    public boolean verificarPersona(Persona persona) {
        for (Persona p : MainActivity.listaPersonas) {
            if (p.getDni().equals(persona.getDni())) {
                return true; // Persona ya existe
            }
        }
        return false; // Persona no existe
    }

    public String agregarPersona(String nombre, String apellido, String dni, String edad){
        Persona p = new Persona(nombre, apellido, dni, edad);
        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || edad.isEmpty()) {
            return "Complete todos los campos.";
        }
        if (verificarPersona(p)) {
            return "Ya existe una persona con este DNI.";
        }
        if (!dni.matches("\\d+")) {
            return "El DNI solo debe contener números.";
        }

        // Verificar que la edad solo contenga números
        if (!edad.matches("\\d+")) {
            return "La edad debe ser un número válido.";
        }
        if (!nombre.matches("[a-zA-Z]+")) {
            return "El nombre solo debe contener letras.";
        }
        if (!apellido.matches("[a-zA-Z]+")) {
            return "El apellido solo debe contener letras.";
        }
        MainActivity.listaPersonas.add(p);
        return "Persona agregada exitosamente.";
    }
}