package com.capicp.quotesbook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.widget.ImageView;


import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import com.capicp.quotesbook.data.Pensamiento;

public class PensamientoActivity extends SherlockFragmentActivity {

    public static final String PENSAMIENTO_MENSAJE = "capicp.test.sherlockdrawer.PENSAMIENTO_MENSAJE";
    public static final String PENSAMIENTO_AUTOR = "capicp.test.sherlockdrawer.PENSAMIENTO_AUTOR";
    public static final String PENSAMIENTO_AUTOR_DESCRIPCION = "capicp.test.sherlockdrawer.PENSAMIENTO_AUTOR_DESCRIPCION";
    public static final String PENSAMIENTO_AUTOR_FOTO = "capicp.test.sherlockdrawer.PENSAMIENTO_AUTOR_FOTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensamiento);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }

        if (savedInstanceState == null){
            Intent i = getIntent();

            Pensamiento pensamiento = new Pensamiento();
            pensamiento.setCita(i.getStringExtra(PENSAMIENTO_MENSAJE));
            pensamiento.setAutor_descripcion(i.getStringExtra(PENSAMIENTO_AUTOR_DESCRIPCION));
            pensamiento.setAutor_nombre(i.getStringExtra(PENSAMIENTO_AUTOR));
            pensamiento.setAutor_foto(i.getStringExtra(PENSAMIENTO_AUTOR_FOTO));

            FragmentPensamiento pensamientoFr = new FragmentPensamiento(pensamiento);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.pensamiento, pensamientoFr);
            ft.commit();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
