package com.capicp.quotesbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.actionbarsherlock.app.SherlockFragment;

import com.capicp.quotesbook.R;
import com.capicp.quotesbook.data.Pensamiento;
import com.capicp.quotesbook.data.PensamientoBDHelper;

/**
 * Created by capi on 22/06/13.
 */
public class FragmentPensamiento extends SherlockFragment {

    private static final String PENSAMIENTO_KEY = "mensaje";
    private static final String AUTOR_KEY = "autor";

    private String mensaje;
    private String autor;
    private String autor_descripcion;
    private String foto;

    public FragmentPensamiento(){
        mensaje = "Seleccione un penasdf";
    }

    public FragmentPensamiento(String mensaje) {

        this.mensaje = mensaje;
    }

    public FragmentPensamiento(Pensamiento pensamiento){

        mensaje = pensamiento.getCita();
        autor = pensamiento.getAutor_nombre();
        autor_descripcion = pensamiento.getAutor_descripcion();
        foto = pensamiento.getAutor_foto();
    }

    public void colocar_pensamiento(Pensamiento p, View pensamiento_view){

        TextView texto = (TextView) pensamiento_view.findViewById(R.id.pensamiento_cuerpo);
        texto.setText("\""+mensaje+"\"");

        if (autor != null ){
            texto = (TextView) pensamiento_view.findViewById(R.id.autor);
            texto.setText("- " + autor + ",");
        }

        if ( autor_descripcion != null ){
            texto = (TextView) pensamiento_view.findViewById(R.id.descripcion_autor);
            texto.setText(autor_descripcion);
        }

        if (foto != null) {
            ImageView i = (ImageView) pensamiento_view.findViewById(R.id.foto);
            i.setImageResource(PensamientoBDHelper.obtenerFoto(foto));
            i.setAdjustViewBounds(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View pensamiento_view = inflater.inflate(R.layout.fragment_pensamiento, container, false);

        Pensamiento p = new Pensamiento();
        p.setAutor_foto(foto);
        p.setCita(mensaje);
        p.setAutor_descripcion(autor_descripcion);
        p.setAutor_nombre(autor);

        colocar_pensamiento(p, pensamiento_view);

        return pensamiento_view;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(PENSAMIENTO_KEY, mensaje);
        outState.putString(AUTOR_KEY, autor);
    }
}
