package com.example.examenmoviles.ui.salir;

import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenmoviles.R;
import com.example.examenmoviles.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment {

    private SalirViewModel mViewModel;
    private FragmentSalirBinding binding;

    public static SalirFragment newInstance() {
        return new SalirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout con ViewBinding
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Configurar el botón de salir
        binding.btSalir.setOnClickListener(v -> mostrarDialogoSalir());

        return root;
    }

    // Método para mostrar el diálogo de confirmación
    private void mostrarDialogoSalir() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Salir")
                .setMessage("¿Estás seguro que deseas salir de la aplicación?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    getActivity().finish();  // Cerrar la aplicación
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Limpiar la referencia del binding
    }
}