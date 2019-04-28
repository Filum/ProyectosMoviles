package cr.ac.una.registromovimientos;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import cr.ac.una.registromovimientos.entity.Movimiento;

public class MovimientoEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento_edit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView descripcion =(TextView) findViewById(R.id.txt_descripcionEdit);
        final TextView fecha =(TextView) findViewById(R.id.txt_fechaEdit);
        final TextView monto =(TextView) findViewById(R.id.txt_montoEdit);
        final RadioGroup ingresogasto =(RadioGroup) findViewById(R.id.rbgroup_Edit);
        final RadioButton botonSeleccionado =(RadioButton) findViewById(ingresogasto.getCheckedRadioButtonId());


        final Integer pos = (Integer) getIntent().getSerializableExtra("position");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


        final Integer tipoMov;
        //editar un movimiento existente
        if(pos != null)
        { String dateAsString = sdf.format(MainActivity.adapter.getMovimientoList().get(pos).getFecha());


            Date now = new Date();


            try {
                Date dateFromString = sdf.parse(dateAsString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            descripcion.setText(MainActivity.adapter.getMovimientoList().get(pos).getDescripcion());
            fecha.setText(dateAsString);
            monto.setText(""+ MainActivity.adapter.getMovimientoList().get(pos).getMonto());

            if(MainActivity.adapter.getMovimientoList().get(pos).getTipo()==0)
            {
                ((RadioButton) findViewById(R.id.rb_gastoEdit)).setChecked(true);

            }else
            {
                ((RadioButton) findViewById(R.id.rb_ingresoEdit)).setChecked(true);
            }
        }


        //agregar un movimiento nuevo
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Integer tipo;
                String datoDescripcion= descripcion.getText().toString();
                Date datoFecha=new Date(fecha.getText().toString());
                Float datoMonto=new Float(monto.getText().toString());
                int id_seleccionado = ingresogasto.getCheckedRadioButtonId();
                if (id_seleccionado == R.id.rb_gastoEdit)
                {
                    tipo =0;

                }else
                {
                    tipo =1;

                }




                //falta arreglar el tipo el resto está listo
                Movimiento movimiento1=new Movimiento(tipo,datoDescripcion,datoFecha,datoMonto);


                if(pos==null)
                {
                    MainActivity.adapter.getMovimientoList().add(movimiento1);
                }else
                {
                    MainActivity.adapter.getMovimientoList().set(pos.intValue(),new Movimiento(tipo,datoDescripcion,datoFecha,datoMonto));
                    MainActivity.adapter.getMovimientoList().get(pos).setDescripcion(datoDescripcion);
                    MainActivity.adapter.getMovimientoList().get(pos).setFecha(datoFecha);
                    MainActivity.adapter.getMovimientoList().get(pos).setMonto(datoMonto);
                    id_seleccionado = ingresogasto.getCheckedRadioButtonId();
                    if (id_seleccionado == R.id.rb_gastoEdit)
                    {
                        MainActivity.adapter.getMovimientoList().get(pos).setTipo(0);

                    }else
                    {
                        MainActivity.adapter.getMovimientoList().get(pos).setTipo(1);

                    }
                }

                MainActivity.adapter.notifyDataSetChanged();
                terminar();
            }
        });
    }
    void terminar()
    {
        this.finish();
    }
}
