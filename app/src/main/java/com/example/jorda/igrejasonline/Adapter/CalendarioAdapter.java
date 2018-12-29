package com.example.jorda.igrejasonline.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jorda.igrejasonline.R;
import com.example.jorda.igrejasonline.domain.ModeloEvento;

import java.util.List;

public class CalendarioAdapter extends ArrayAdapter<ModeloEvento> {

    private Context context;
    private List<ModeloEvento> eventos;

    public CalendarioAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ModeloEvento> objects) {
        super(context, resource, objects);
        this.context = context;
        this.eventos = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.unica_evento, parent, false);

        // Montar a imagem com base na primeira letra do nome

        TextView calendarioTitulo      = rowView.findViewById(R.id.txt_calendarioTitulo);
        TextView calendarioDataInicio  = rowView.findViewById(R.id.txt_calendarioDataInicio);
        TextView calendarioHoraInicio  = rowView.findViewById(R.id.txt_calendarioHoraInicio);
        TextView calendarioDataTermino = rowView.findViewById(R.id.txt_calendarioDataTermino);
        TextView calendarioHoraTermino = rowView.findViewById(R.id.txt_calendarioHoraTermino);

        calendarioTitulo.setText(String.format("Evento: %s",eventos.get(pos).getTitulo()));
        calendarioDataInicio.setText((String.format("%s",eventos.get(pos).getDataInicio())));
        calendarioHoraInicio.setText((String.format("%s",eventos.get(pos).getHoraInicio())));
        calendarioDataTermino.setText((String.format("%s",eventos.get(pos).getDataTermino())));
        calendarioHoraTermino.setText((String.format("%s",eventos.get(pos).getHoraTermino())));


        return rowView;
    }

    public int getItemCount() {
        return eventos.size();
    }


}