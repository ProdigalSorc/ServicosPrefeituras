package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.helper.ResumoMultaHelper;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.intefaces.PacoteActivityConstantes.CHAVE_MULTA_RETORNO;
import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.intefaces.PacoteActivityConstantes.CHAVE_TIPO_ACESSO;


public class ResumoMultaActivity extends BaseActivity {

    private ResumoMultaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_multa);
        helper = new ResumoMultaHelper(this);
        carregaMultaRecebido();
    }

    private void carregaMultaRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_MULTA_RETORNO)) {
//            TODO - Troca Serializable para Parcelable
//            final MultaRetorno multaRetorno = intent.getExtras().getParcelable(CHAVE_MULTA_RETORNO);
            MultaRetorno multaRetorno = (MultaRetorno) intent.getSerializableExtra(CHAVE_MULTA_RETORNO);
            String tipoAcesso = (String) intent.getSerializableExtra(CHAVE_TIPO_ACESSO);
            if (multaRetorno != null && tipoAcesso != null) {
                helper.preenche(multaRetorno, tipoAcesso);
            }
        }
    }
}
