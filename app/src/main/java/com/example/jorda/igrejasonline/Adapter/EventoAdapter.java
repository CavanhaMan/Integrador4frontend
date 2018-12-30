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
import com.example.jorda.igrejasonline.domain.Evento;

import java.util.List;

public class EventoAdapter extends ArrayAdapter<Evento> {

    private Context context;
    private List<Evento> eventos;

    public EventoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
        this.context = context;
        this.eventos = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.unica_evento, parent, false);

        // Montar a imagem com base na primeira letra do nome

        TextView eventoTitulo      = rowView.findViewById(R.id.txt_eventoTitulo);
        TextView eventoDataInicio  = rowView.findViewById(R.id.txt_eventoDataInicio);
        TextView eventoHoraInicio  = rowView.findViewById(R.id.txt_eventoHoraInicio);
        TextView eventoDataTermino = rowView.findViewById(R.id.txt_eventoDataTermino);
        TextView eventoHoraTermino = rowView.findViewById(R.id.txt_eventoHoraTermino);

        eventoTitulo.setText(String.format("Evento: %s",eventos.get(pos).getTitulo()));
        eventoDataInicio.setText((String.format("%s",eventos.get(pos).getDataInicio())));
        eventoHoraInicio.setText((String.format("%s",eventos.get(pos).getHoraInicio())));
        eventoDataTermino.setText((String.format("%s",eventos.get(pos).getDataTermino())));
        eventoHoraTermino.setText((String.format("%s",eventos.get(pos).getHoraTermino())));


        return rowView;
    }

    public int getItemCount() {
        return eventos.size();
    }


}