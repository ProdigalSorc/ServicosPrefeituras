package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.interfaces;

import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;

public interface ItemClickListener {
    void onItemClick(MultaRetorno multa);

    void onLongClick(List<MultaRetorno> multas);
}
