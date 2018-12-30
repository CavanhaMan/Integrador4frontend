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
import com.example.jorda.igrejasonline.domain.Igreja;

import java.util.List;

public class IgrejaAdapter extends ArrayAdapter<Igreja> {

    private Context context;
    private List<Igreja> igrejas;

    public IgrejaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Igreja> objects) {
        super(context, resource, objects);
        this.context = context;
        this.igrejas = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.unica_igreja, parent, false);

        TextView txtIgrejaId = (TextView) rowView.findViewById(R.id.txt_igrejaId);
        TextView txtIgrejaCnjp = (TextView) rowView.findViewById(R.id.txtIgrejaCnpj);
        TextView txtIgrejaNome = (TextView) rowView.findViewById(R.id.txtIgrejaNome);
        TextView txtIgrejaTelefone = (TextView) rowView.findViewById(R.id.txtIgrejaTelefone);

        txtIgrejaId.setText(String.format("ID: %s", igrejas.get(pos).getId()));
        txtIgrejaCnjp.setText(String.format("CNJP: %s", igrejas.get(pos).getCnpj()));
        txtIgrejaNome.setText(String.format("%s", igrejas.get(pos).getNome()));
        txtIgrejaTelefone.setText(String.format("Telefone:  %s", igrejas.get(pos).getTelefone()));

        return rowView;
    }

    public int getItemCount() {
        return igrejas.size();
    }


}