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

	public static final String PENSAMIENTO_OBJETO = "com.capicp.quotesbook.PENSAMIENTO";
    public static final String PENSAMIENTO_MENSAJE = "com.capicp.quotesbook.PENSAMIENTO_MENSAJE";
    public static final String PENSAMIENTO_AUTOR = "com.capicp.quotesbook.PENSAMIENTO_AUTOR";
    public static final String PENSAMIENTO_AUTOR_DESCRIPCION = "com.capicp.quotesbook.PENSAMIENTO_AUTOR_DESCRIPCION";
    public static final String PENSAMIENTO_AUTOR_FOTO = "com.capicp.quotesbook.PENSAMIENTO_AUTOR_FOTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensamiento);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }

        if (savedInstanceState == null){
            Intent i = getIntent();

            Pensamiento pensamiento = i.getExtras().getParcelable(PENSAMIENTO_OBJETO);
            
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
