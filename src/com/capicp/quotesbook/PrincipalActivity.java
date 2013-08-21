package com.capicp.quotesbook;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import com.capicp.quotesbook.tasks.PensamientoServicio;

public class PrincipalActivity extends DrawerActivity {

    public static final String CATEGORIA_KEY = "capicp.quotesbook.CATEGORIA";
    public static final String PENSAMIENTO_ID_KEY= "capicp.quotesbook.PENSAMIENTO_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentListaPensamientos listado = new FragmentListaPensamientos();
        Intent i = getIntent();

        int categoria;
        long pensamiento_id;

        categoria = i.getIntExtra(CATEGORIA_KEY, -1);
        pensamiento_id = i.getLongExtra(PENSAMIENTO_ID_KEY, -1);


        if (categoria != -1)
            listado = new FragmentListaPensamientos(categoria, pensamiento_id);


        Log.d("Principal", "Llegó aquí");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.listado, listado);
        ft.commit();


        Intent is = new Intent(this, PensamientoServicio.class);
        startService(is);

    }


}
