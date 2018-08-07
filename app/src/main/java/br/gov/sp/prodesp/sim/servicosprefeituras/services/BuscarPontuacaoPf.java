package br.gov.sp.prodesp.sim.servicosprefeituras.services;

import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BuscarPontuacaoPf {
    @GET("/pontuacao/cpf/")
    Call<MultaRetorno> buscarPontuacao();
}
