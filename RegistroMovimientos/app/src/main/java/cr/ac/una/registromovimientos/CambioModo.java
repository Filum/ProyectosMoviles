package cr.ac.una.registromovimientos;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class CambioModo extends AppCompatActivity {


    public static boolean modoOscuro=false;


    public void switchClick(View view)
    {
        Switch sw=(Switch) findViewById(R.id.switch2);




        if(sw.isChecked()==true)
        {
            modoOscuro= true;
            Snackbar.make(view, "Se cambio el modo a OSCURO", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
            cambiarVentana(true);
        }else
        {
            modoOscuro=false;

            Snackbar.make(view, "Se cambió el modo a Claro", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            cambiarVentana(false);
        }
    }


    public void cambiarVentana(boolean estado)
    {
        ConstraintLayout ct= findViewById(R.id.ct);
        TextView tv=findViewById(R.id.textView);

        if(estado==true)
        {
            ct.setBackgroundColor(Color.parseColor("#FF363A54"));
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            ct.setBackgroundColor(Color.parseColor("#FFFFFF"));
            tv.setTextColor(Color.parseColor("#FF363A54"));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_modo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        cambiarVentana(modoOscuro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent=new Intent(CambioModo.this,CambioModo.class);
            startActivity(intent);

        }

        if (id == R.id.menu_principal) {

            Intent intent=new Intent(CambioModo.this,MainActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

}
