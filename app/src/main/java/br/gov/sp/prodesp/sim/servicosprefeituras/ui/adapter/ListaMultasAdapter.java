package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.helper.MultaViewHolder;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.interfaces.ItemClickListener;

public class ListaMultasAdapter extends RecyclerView.Adapter<MultaViewHolder> implements View.OnClickListener {

    private final List<MultaRetorno> multas;
    private final Context context;
    private static ItemClickListener itemClickListener;
    private MultaRetorno multaRetorno;

    public ListaMultasAdapter(List<MultaRetorno> multas, Context context) {
        this.multas = multas;
        this.context = context;
    }

    @NonNull
    @Override
    public MultaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_multa, parent, false);
        return new MultaViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull MultaViewHolder holder, int position) {
        multaRetorno = multas.get(position);
        holder.vincula(multaRetorno);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return multas.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        if(itemClickListener != null) {
            itemClickListener.onItemClick(multaRetorno);
        }
    }
}
