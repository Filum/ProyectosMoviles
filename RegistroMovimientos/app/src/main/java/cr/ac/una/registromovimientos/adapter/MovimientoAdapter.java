package cr.ac.una.registromovimientos.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cr.ac.una.registromovimientos.R;
import cr.ac.una.registromovimientos.entity.Movimiento;

public class MovimientoAdapter extends RecyclerView.Adapter<MovimientoAdapter.ViewHolder> {

    private List<Movimiento> movimientoList;


    public MovimientoAdapter(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;

    }

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movimiento_list,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String descripcion = movimientoList.get(i).getDescripcion();
        String fecha = movimientoList.get(i).getFecha().toString();
        String monto = new Float(movimientoList.get(i).getMonto()).toString();


        viewHolder.descripcion.setText(descripcion);
        viewHolder.fecha.setText(fecha);
        viewHolder.monto.setText(monto);


    }

    @Override
    public int getItemCount() {
        return movimientoList.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView descripcion;
        private TextView fecha;
        private TextView monto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion = itemView.findViewById(R.id.descripcion);
            fecha = itemView.findViewById(R.id.fecha);
            monto = itemView.findViewById(R.id.monto);
        }
    }
}
