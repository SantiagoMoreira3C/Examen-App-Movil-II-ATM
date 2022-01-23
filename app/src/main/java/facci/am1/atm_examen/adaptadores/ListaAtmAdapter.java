package facci.am1.atm_examen.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import facci.am1.atm_examen.ConsultaIndividual;
import facci.am1.atm_examen.R;
import facci.am1.atm_examen.entidades.Atm;

public class ListaAtmAdapter extends RecyclerView.Adapter<ListaAtmAdapter.AtmViewHolder> {

    ArrayList<Atm> listaAtm;

    public ListaAtmAdapter(ArrayList<Atm> listaAtm) {
        this.listaAtm = listaAtm;


    }

    @NonNull
    @Override
    public AtmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_atm, null, false);
      return new AtmViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AtmViewHolder holder, int position) {
        holder.viewNombres.setText(listaAtm.get(position).getNombres());
        holder.viewTipocar.setText(listaAtm.get(position).getTipocar());
        holder.viewCorp.setText(listaAtm.get(position).getCorp());


    }

    @Override
    public int getItemCount() {
        return listaAtm.size();


    }


    public class AtmViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombres, viewTipocar, viewCorp;

        public AtmViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombres = itemView.findViewById(R.id.viewNombres);
            viewTipocar = itemView.findViewById(R.id.viewTipocar);
            viewCorp = itemView.findViewById(R.id.viewCorp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ConsultaIndividual.class);
                    intent.putExtra("ID", listaAtm.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
