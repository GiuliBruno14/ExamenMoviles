package com.example.examenmoviles.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenmoviles.R;
import com.example.examenmoviles.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.ViewHolder> {

    private List<Persona> listaPersonas;

    public ListarAdapter(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_persona, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Persona persona = listaPersonas.get(position);
        holder.textViewNombre.setText(persona.getNombre() + " " + persona.getApellido());
        holder.textViewDni.setText("DNI: " + persona.getDni());
        holder.textViewEdad.setText("Edad: " + persona.getEdad());
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }
    public void actualizarLista(List<Persona> nuevasPersonas) {
        this.listaPersonas = nuevasPersonas;
        notifyDataSetChanged();  // Notificar al adaptador que los datos cambiaron
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        TextView textViewDni;
        TextView textViewEdad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewDni = itemView.findViewById(R.id.textViewDni);
            textViewEdad = itemView.findViewById(R.id.textViewEdad);
        }
    }
}
