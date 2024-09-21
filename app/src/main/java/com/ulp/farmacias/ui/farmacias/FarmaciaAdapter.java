package com.ulp.farmacias.ui.farmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ulp.farmacias.R;
import com.ulp.farmacias.model.Farmacia;

import java.util.List;

public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.ViewHolderFarmacia> {

    private List<Farmacia> farmacias;
    private LayoutInflater inflater;

    public FarmaciaAdapter(List<Farmacia> farmacias, LayoutInflater inflater) {
        this.farmacias = farmacias;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolderFarmacia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderFarmacia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFarmacia holder, int position) {
        Farmacia farmacia = farmacias.get(position);
        holder.tvNombre.setText(farmacia.getNombre());
        holder.tvDireccion.setText(farmacia.getDireccion());
        holder.tvHorario.setText(farmacia.getHorario());
        holder.ivFoto.setImageResource(farmacia.getFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("farmacia", farmacia);
                Navigation.findNavController(view).navigate(R.id.detalleFarmaciaFragment, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return farmacias.size();
    }

    public class ViewHolderFarmacia extends RecyclerView.ViewHolder {

        TextView tvNombre, tvDireccion, tvHorario;
        ImageView ivFoto;

        public ViewHolderFarmacia(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvHorario = itemView.findViewById(R.id.tvHorario);
            ivFoto = itemView.findViewById(R.id.ivFoto);

        }
    }

}
