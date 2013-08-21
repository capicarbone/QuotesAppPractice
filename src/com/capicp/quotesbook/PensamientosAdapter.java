package com.capicp.quotesbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.capicp.quotesbook.data.Pensamiento;
import com.capicp.quotesbook.data.PensamientoBDHelper;

/**
 * Created by capi on 30/06/13.
 */
public class PensamientosAdapter extends ArrayAdapter<Pensamiento> {

    public PensamientosAdapter(Context context, List<Pensamiento> objects) {
        super(context, R.layout.pensamiento_list_view, objects);

    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {

        if (vista == null){

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.pensamiento_list_view, parent, false);

        }

        Pensamiento p = getItem(position);

        TextView texto = (TextView) vista.findViewById(R.id.pensamiento_preview);
        texto.setText(p.getCita().substring(0,23) + "...");

        texto = (TextView) vista.findViewById(R.id.autor_apellido);
        String[] nombres = p.getAutor_nombre().split(" ");

        texto.setText(nombres[nombres.length-1]);

        ImageView imagen = (ImageView) vista.findViewById(R.id.foto_list_view);
        imagen.setImageResource(PensamientoBDHelper.obtenerFoto(p.getAutor_foto()));

        return vista;
    }
}
