package com.example.examenmoviles.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.examenmoviles.R;
import com.example.examenmoviles.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private CargarViewModel mv;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btGuardar.setOnClickListener(v -> {
            guardarPersona();
            limpiar();
        });
        return root;
    }

    private void guardarPersona() {  //Guarda los datos ingresados
        String nombre = binding.etNombre.getText().toString();
        String apellido = binding.etApellido.getText().toString();
        String dni = binding.etDni.getText().toString();
        String edad = binding.etEdad.getText().toString();
        String respuesta = mv.agregarPersona(nombre, apellido, dni, edad); //Agrega persona a la lista
        Toast.makeText(getContext(), respuesta, Toast.LENGTH_SHORT).show();
    }

    private void limpiar(){  //Limpia la vista
        binding.etNombre.setText("");
        binding.etApellido.setText("");
        binding.etDni.setText("");
        binding.etEdad.setText("");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Limpiar referencia de binding
    }
}
