package com.example.examenmoviles.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenmoviles.MainActivity;
import com.example.examenmoviles.modelo.Persona;

import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<Persona>> listaPersonas;

    public ListarViewModel() {
        listaPersonas = new MutableLiveData<>(new ArrayList<>(MainActivity.listaPersonas));
    }

    public LiveData<ArrayList<Persona>> getListaPersonas() {
        return listaPersonas;
    }

    public void actualizarLista() {
        ArrayList<Persona> personasActualizadas = new ArrayList<>(MainActivity.listaPersonas);
        Collections.sort(personasActualizadas, (p1, p2) ->
                Integer.compare(Integer.parseInt(p2.getEdad()), Integer.parseInt(p1.getEdad()))
        );
        listaPersonas.setValue(personasActualizadas);  // Actualizar LiveData con la lista ordenada
    }

}