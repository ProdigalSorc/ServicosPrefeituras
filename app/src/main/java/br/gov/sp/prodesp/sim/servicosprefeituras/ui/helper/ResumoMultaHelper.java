package br.gov.sp.prodesp.sim.servicosprefeituras.ui.helper;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.CpfCnpjLoginActivity;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.IndicacaoCondutorActivity;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.ResumoMultaActivity;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.DataUtil;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.intefaces.PacoteActivityConstantes.CHAVE_TIPO_ACESSO;

public class ResumoMultaHelper {

    private final TextView placa;
    private final TextView marca;
    private final TextView especie;
    private final TextView dataEmissao;
    private final TextView nomeProprietario;
    private final TextView descricaoInfracao;
    private final TextView enquadramento;
    private final TextView localInfracao;
    private final TextView dataInfracao;
    private final TextView horaInfracao;
    private final TextView pontuacao;
    private final TextView dataLimite;
    private final ResumoMultaActivity activity;

    private MultaRetorno multaRetorno;

    public ResumoMultaHelper(final ResumoMultaActivity activity) {
        this.activity = activity;
        placa = activity.findViewById(R.id.activity_resumo_multa_placa);
        marca = activity.findViewById(R.id.activity_resumo_multa_marca);
        especie = activity.findViewById(R.id.activity_resumo_multa_especie);
        dataEmissao = activity.findViewById(R.id.activity_resumo_multa_data_emissao);
        nomeProprietario = activity.findViewById(R.id.activity_resumo_multa_nome_proprietario);
        descricaoInfracao = activity.findViewById(R.id.activity_resumo_multa_descricao_infracao);
        enquadramento = activity.findViewById(R.id.activity_resumo_multa_enquadramento);
        localInfracao = activity.findViewById(R.id.activity_resumo_multa_local_infracao);
        dataInfracao = activity.findViewById(R.id.activity_resumo_multa_data_infracao);
        horaInfracao = activity.findViewById(R.id.activity_resumo_multa_hora_infracao);
        pontuacao = activity.findViewById(R.id.activity_resumo_multa_pontuacao);
        dataLimite = activity.findViewById(R.id.activity_resumo_multa_data_limite);
        multaRetorno = new MultaRetorno();
    }

//    private void mostraBotaoAutoIndicarMulta(final String tipoAcesso) {
//        Button btnAutoIndicarMulta = activity.findViewById(R.id.activity_resumo_button_auto_indicar);
//        btnAutoIndicarMulta.setVisibility(View.VISIBLE);
//        btnAutoIndicarMulta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                abrirAutoIndicacao(activity, tipoAcesso);
//            }
//        });
//    }

    private void mostraBotaoIndicarCondutor() {
        Button btnIndicarCondutor = activity.findViewById(R.id.activity_resumo_button_indicar_condutor);
        btnIndicarCondutor.setVisibility(View.VISIBLE);
        btnIndicarCondutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirIndicarCondutor(activity);
            }
        });
    }

    public void preenche(MultaRetorno multaRetorno, String tipoAcesso) {
        placa.setText(multaRetorno.getPlaca());
        marca.setText(multaRetorno.getMarca());
        especie.setText(multaRetorno.getEspecie());
        dataEmissao.setText(DataUtil.dataEmTexto(multaRetorno.getDataEmissao()));
        nomeProprietario.setText(multaRetorno.getNomeProprietario());
        descricaoInfracao.setText(multaRetorno.getDescricaoInfracao());
        enquadramento.setText(multaRetorno.getEnquadramento());
        localInfracao.setText(multaRetorno.getLocalInfracao());
        dataInfracao.setText(DataUtil.dataEmTexto(multaRetorno.getDataInfracao()));
        horaInfracao.setText(DataUtil.horaEmTexto(multaRetorno.getHoraInfracao()));
        pontuacao.setText(multaRetorno.getPontosCnh());
        dataLimite.setText(DataUtil.dataEmTexto(multaRetorno.getDataLimite()));
        if (tipoAcesso.equals(Constantes.TIPO_ACESSO_CPF)) {
            mostraBotaoIndicarCondutor();
        } else {
//            mostraBotaoAutoIndicarMulta(tipoAcesso);
        }
        this.multaRetorno = multaRetorno;
    }

    private void abrirIndicarCondutor(ResumoMultaActivity activity) {
        Intent intentIndicarCondutor = new Intent(activity, IndicacaoCondutorActivity.class);
        activity.startActivity(intentIndicarCondutor);
        activity.setResultOK();
    }

    private void abrirAutoIndicacao(ResumoMultaActivity activity, String tipoAcesso) {
        Intent intentAutoIndicacao = new Intent(activity, CpfCnpjLoginActivity.class);
        intentAutoIndicacao.putExtra(CHAVE_TIPO_ACESSO, tipoAcesso);
        activity.startActivity(intentAutoIndicacao);
        activity.setResultOK();
    }
}
