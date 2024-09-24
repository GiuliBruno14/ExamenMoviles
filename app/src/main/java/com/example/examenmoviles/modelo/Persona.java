package com.example.examenmoviles.modelo;

public class Persona {
    private String dni;
    private String apellido;
    private String nombre;
    private String edad;

    public Persona(String nombre, String apellido, String dni, String edad) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }


}
