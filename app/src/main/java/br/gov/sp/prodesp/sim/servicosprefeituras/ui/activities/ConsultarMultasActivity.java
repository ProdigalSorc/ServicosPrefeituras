package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.enums.SituacaoMultaEnum;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.ListaMultasAdapter;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.intefaces.PacoteActivityConstantes.CHAVE_MULTA_RETORNO;
import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.intefaces.PacoteActivityConstantes.CHAVE_TIPO_ACESSO;


public class ConsultarMultasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<MultaRetorno> list;
    private String tipoAcesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_multas);

        ListView listaDeMultas = findViewById(R.id.activity_consultar_multas_lista);

        TextView cpfUsuario = findViewById(R.id.activity_consultar_multas_cpf_usuario);
        cpfUsuario.setText("012.345.678-10");

        TextView cnhUsuario = findViewById(R.id.activity_consultar_multas_cnh_usuario);
        cnhUsuario.setText("987.654.321.00");

        getMultaRetornoExemplo();
        carregaTipoAcesso();

        montaAdapter(listaDeMultas);
        listaDeMultas.setOnItemClickListener(this);
    }

    private void montaAdapter(ListView listaDeMultas) {
        ListaMultasAdapter adapter = new ListaMultasAdapter(list, ConsultarMultasActivity.this);
        listaDeMultas.setAdapter(adapter);
    }

    private void carregaTipoAcesso() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_TIPO_ACESSO)) {
            tipoAcesso = (String) intent.getSerializableExtra(CHAVE_TIPO_ACESSO);
        }
    }

    @NonNull
    private void getMultaRetornoExemplo() {
        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            MultaRetorno multaRetorno = new MultaRetorno();
            multaRetorno.setId(i);
            multaRetorno.setDataInfracao(Calendar.getInstance());
            multaRetorno.setHoraInfracao(Calendar.getInstance());
            multaRetorno.setPlaca("BIT-0010");
            multaRetorno.setMarca("Gol 1.0");
            multaRetorno.setEspecie("Passageiro");
            multaRetorno.setNomeProprietario("José da Silva");
            multaRetorno.setDataEmissao(Calendar.getInstance());
            multaRetorno.setDescricaoInfracao("Avançar o sinal vermelho do semáforo");
            multaRetorno.setEnquadramento("605-0");
            multaRetorno.setLocalInfracao("Avenida Paulista");
            multaRetorno.setPontosCnh("10");
            multaRetorno.setDataLimite(Calendar.getInstance());
            multaRetorno.setSituacaoMultaEnum(SituacaoMultaEnum.AIT_EM_ANALISE);
            list.add(multaRetorno);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MultaRetorno multaRetorno = (MultaRetorno) parent.getAdapter().getItem(position);
        if (multaRetorno != null) {
            Intent intent = new Intent(ConsultarMultasActivity.this, ResumoMultaActivity.class);
            intent.putExtra(CHAVE_MULTA_RETORNO, multaRetorno);
            intent.putExtra(CHAVE_TIPO_ACESSO, tipoAcesso);
            startActivity(intent);
        }
    }
}
