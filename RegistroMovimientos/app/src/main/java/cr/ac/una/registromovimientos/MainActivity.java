package cr.ac.una.registromovimientos;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cr.ac.una.registromovimientos.adapter.MovimientoAdapter;
import cr.ac.una.registromovimientos.controller.SwipeController;
import cr.ac.una.registromovimientos.controller.SwipeControllerActions;
import cr.ac.una.registromovimientos.entity.Movimiento;

public class MainActivity extends AppCompatActivity {


    private RecyclerView movimientoView;
    static  MovimientoAdapter adapter;
    private List<Movimiento> movimiento;
    SwipeController swipeController = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movimientoView = findViewById(R.id.recyclerViewUser);

        if(CambioModo.modoOscuro==true)
        {
            movimientoView.setBackgroundColor(Color.parseColor("#FF363A54"));
        }
        else
        {
            movimientoView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
                Intent intent= new Intent(MainActivity.this, MovimientoEdit.class);
                startActivity(intent);


            }
        });


        movimiento = new ArrayList<>();

        movimiento.add(new Movimiento(1,"nuevo deposito",new Date(2018,3,3),50000));
        movimiento.add(new Movimiento(0,"pago de casa",new Date(2018,4,20),100000));
        movimiento.add(new Movimiento(0," deposito paseo",new Date(2018,2,15),15000));
        movimiento.add(new Movimiento(0,"comida en restaurante",new Date(2018,1,6),7350));
        movimiento.add(new Movimiento(1,"trabajo contratado",new Date(2018,3,7),245000));
        movimiento.add(new Movimiento(1, "sfsdfsdfsdfsd", new Date(2018,3,3), 3333));
        movimiento.add(new Movimiento(1, "dddddddddd", new Date(2018,3,3), 3333));
        movimiento.add(new Movimiento(1, "sfsdfsdfsdfsd", new Date(2018,3,3), 3333));
        movimiento.add(new Movimiento(1, "sfsdfsdfsdfsd", new Date(2018,3,3), 3333));
        movimiento.add(new Movimiento(1, "sfsdfsdfsdfsd", new Date(2018,3,3), 3333));
        adapter = new MovimientoAdapter(movimiento);


        setupRecyclerView();

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

            Intent intent=new Intent(MainActivity.this,CambioModo.class);
            startActivity(intent);

        }

        if (id == R.id.menu_principal) {

            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewUser);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                adapter.getMovimientoList().remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());
            }

            @Override
            public void onLeftClicked(int position) {

                Intent intent=new Intent(MainActivity.this,MovimientoEdit.class);
                intent.putExtra("position",Integer.valueOf(position));
                startActivity(intent);
            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }
}


