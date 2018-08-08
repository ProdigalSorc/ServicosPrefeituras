package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.DataUtil;

public class MultaViewHolder extends RecyclerView.ViewHolder {

    private final TextView campoDataInfracao;
    private final TextView campoHoraInfracao;
    private final TextView campoPontos;
    private final TextView campoPlaca;
    private final TextView campoSituacao;
    private final ConstraintLayout cardView;

    public MultaViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.item_multa_constraint_layout);
        campoDataInfracao = itemView.findViewById(R.id.item_multa_data_infracao);
        campoHoraInfracao = itemView.findViewById(R.id.item_multa_hora_infracao);
        campoPontos = itemView.findViewById(R.id.item_multa_pontos);
        campoPlaca = itemView.findViewById(R.id.item_multa_placa);
        campoSituacao = itemView.findViewById(R.id.item_multa_situacao);
    }

    public void vincula(MultaRetorno multaRetorno) {
        preencheCampos(multaRetorno);
    }

    private void preencheCampos(MultaRetorno multa) {
        campoDataInfracao.setText(DataUtil.dataEmTexto(multa.getDataInfracao()));
        campoHoraInfracao.setText(DataUtil.horaEmTexto(multa.getHoraInfracao()));
        campoPlaca.setText(multa.getPlaca());
        campoPontos.setText(multa.getPontosCnh());
        campoSituacao.setText(multa.getSituacaoMultaEnum().getSituacaoMulta());
    }

    public void changeBackground(Context context, MultaRetorno multaRetorno) {
        Drawable itemBranco = getDrawableItemBranco(context);
        Drawable itemAzul = getDrawableItemAzul(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            cardView.setBackground(multaRetorno.isSelected() ? itemAzul : itemBranco);
        }
    }

    private Drawable getDrawableItemBranco(Context context) {
        return context.getResources().getDrawable(R.drawable.state_selected);
    }

    private Drawable getDrawableItemAzul(Context context) {
        return context.getResources().getDrawable(R.drawable.item_blue);
    }
}
