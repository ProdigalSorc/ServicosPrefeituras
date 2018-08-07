package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.helper.MultaViewHolder;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.interfaces.ItemClickListener;

public class ListaMultasAdapter extends RecyclerView.Adapter<MultaViewHolder> {

    private final List<MultaRetorno> multas;
    private final Context context;
    private static ItemClickListener itemClickListener;
    private static ItemClickListener longClickListener;
    private MultaRetorno multaRetorno;
    private List<MultaRetorno> multasRetorno = new ArrayList<>();
    private MultaViewHolder holder;

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
    public void onBindViewHolder(@NonNull final MultaViewHolder holder, int position) {
        this.holder = holder;
        final MultaRetorno multaRetorno = multas.get(position);
        holder.vincula(multaRetorno);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(multaRetorno);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null && multaRetorno != null) {
                    multaRetorno.setSelected(!multaRetorno.isSelected());
                    holder.changeBackground(multaRetorno);
                    addOrRemove(multaRetorno);
                    longClickListener.onLongClick(multasRetorno);
                    return true;
                }
                return false;
            }
        });
    }

    private void addOrRemove(MultaRetorno multaRetorno) {
        if (multaRetorno.isSelected()) {
            multasRetorno.add(multaRetorno);
        } else {
            multasRetorno.remove(multaRetorno);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return multas.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnLongClickListener(ItemClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public void deselecionaTodos() {
        for (MultaRetorno multaRetorno : multas) {
            multaRetorno.setSelected(false);
            holder.changeBackground(multaRetorno);
        }
    }
//
//    @Override
//    public void onClick(View v) {
//        if (itemClickListener != null) {
//            itemClickListener.onItemClick(multas.get(lastSelectedPosition));
//        }
//    }

//    @Override
//    public boolean onLongClick(View view) {
//        if (longClickListener != null && multaRetorno != null) {
//            multaRetorno.setSelected(!multaRetorno.isSelected());
//            holder.itemView.setBackgroundColor(multaRetorno.isSelected() ? Color.CYAN : Color.WHITE);
//            multasRetorno.add(multaRetorno);
//            longClickListener.onLongClick(multasRetorno);
//            return true;
//        }
//        return false;
//    }
}
