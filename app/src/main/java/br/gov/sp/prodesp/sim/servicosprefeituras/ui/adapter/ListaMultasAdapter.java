package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.DataUtil;

public class ListaMultasAdapter extends BaseAdapter {

    private final List<MultaRetorno> multas;
    private final Context context;

    public ListaMultasAdapter(List<MultaRetorno> multas, Context context) {
        this.multas = multas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return multas.size();
    }

    @Override
    public MultaRetorno getItem(int position) {
        return multas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View viewCriada = convertView;
        if (viewCriada == null) {
            viewCriada = inflater.inflate(R.layout.item_multa, parent, false);
        }

        MultaRetorno multa = multas.get(position);

        TextView campoDataInfracao = viewCriada.findViewById(R.id.item_multa_data_infracao);
        campoDataInfracao.setText(DataUtil.dataEmTexto(multa.getDataInfracao()));

        TextView campoHoraInfracao = viewCriada.findViewById(R.id.item_multa_hora_infracao);
        campoHoraInfracao.setText(DataUtil.horaEmTexto(multa.getHoraInfracao()));

        TextView campoPlaca = viewCriada.findViewById(R.id.item_multa_placa);
        campoPlaca.setText(multa.getPlaca());

        TextView campoPontos = viewCriada.findViewById(R.id.item_multa_pontos);
        campoPontos.setText(multa.getPontosCnh());

        TextView campoSituacao = viewCriada.findViewById(R.id.item_multa_situacao);
        campoSituacao.setText(multa.getSituacaoMultaEnum().getSituacaoMulta());

        return viewCriada;
    }
}
