package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private static final int FOOTER_VIEW = 1;
    private final List<MultaRetorno> multas;
    private final Context context;
    private static ItemClickListener itemClickListener;
    private static ItemClickListener longClickListener;
    private List<MultaRetorno> multasRetorno = new ArrayList<>();
    private MultaViewHolder holder;
    private int itensSelecionados;

    public ListaMultasAdapter(List<MultaRetorno> multas, Context context) {
        itensSelecionados = 0;
        Log.e("ListaMultasAdapter", "itensSelecionados: " + itensSelecionados );
        this.multas = multas;
        this.context = context;
    }

    @NonNull
    @Override
    public MultaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewCriada;

        if (viewType == FOOTER_VIEW) {
            viewCriada = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_branco, parent, false);

            return new FooterViewHolder(viewCriada);
        }

        viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_multa, parent, false);
        return new MultaViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull final MultaViewHolder holder, int position) {
        try {
            // TODO - Corrigir criação da view Holder
            if (holder instanceof MultaViewHolder) {
                this.holder = holder;
                final MultaRetorno multaRetorno = multas.get(position);
                holder.vincula(multaRetorno);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("ListaMultasAdapter", "setOnClickListener itensSelecionados: " + itensSelecionados);
                        if (itensSelecionados == 0) {
                            itemClickListener.onItemClick(multaRetorno);
                        } else{
                            configuraComportamentoLongoClique(multaRetorno, holder);
                        }
                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return configuraComportamentoLongoClique(multaRetorno, holder);
                    }
                });
            } else if (holder instanceof FooterViewHolder) {
                FooterViewHolder vh = (FooterViewHolder) holder;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean configuraComportamentoLongoClique(MultaRetorno multaRetorno, @NonNull MultaViewHolder holder) {
        if (longClickListener != null && multaRetorno != null) {
            configuraViewSelecionada(multaRetorno, holder);
            longClickListener.onLongClick(multasRetorno);
            return true;
        }
        return false;
    }

    private void configuraViewSelecionada(MultaRetorno multaRetorno, @NonNull MultaViewHolder holder) {
        multaRetorno.setSelected(!multaRetorno.isSelected());
        setaQuantidadeItensSelecionados(multaRetorno);
        holder.changeBackground(context, multaRetorno);
        addOrRemove(multaRetorno);
    }

    private void setaQuantidadeItensSelecionados(MultaRetorno multaRetorno) {
        if (multaRetorno.isSelected()){
            Log.e("ListaMultasAdapter", "configuraViewSelecionada multaRetorno.isSelected(): " + multaRetorno.isSelected() );
            itensSelecionados++;
        } else {
            Log.e("ListaMultasAdapter", "configuraViewSelecionada multaRetorno.isSelected(): " + multaRetorno.isSelected() );
            itensSelecionados--;
        }
        Log.e("ListaMultasAdapter", "configuraViewSelecionada itensSelecionados: " + itensSelecionados );
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
        if (multas == null) {
            return 0;
        }

        if (multas.size() == 0) {
            //Return 1 here to show nothing
            return 1;
        }

        // Add extra view to show the footer view
        return multas.size() + 1;
//        return multas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == multas.size()) {
            // This is where we'll add footer.
            return FOOTER_VIEW;
        }

        return super.getItemViewType(position);
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
//            holder.changeBackground(multaRetorno);
        }
    }

    public class FooterViewHolder extends MultaViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Do whatever you want on clicking the item
//                }
//            });
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
