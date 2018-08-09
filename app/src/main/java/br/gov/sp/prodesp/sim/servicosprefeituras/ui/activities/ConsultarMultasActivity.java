package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.MultaRetorno;
import br.gov.sp.prodesp.sim.servicosprefeituras.model.enums.SituacaoMultaEnum;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.ListaMultasAdapter;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.interfaces.ItemClickListener;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.intefaces.InterfacesActivityConstantes.CHAVE_MULTA_RETORNO;
import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.intefaces.InterfacesActivityConstantes.CHAVE_TIPO_ACESSO;
import static br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes.INDICAR_CONDUTOR;


public class ConsultarMultasActivity extends BaseActivity implements ItemClickListener, View.OnClickListener {

    private List<MultaRetorno> list;
    private String tipoAcesso;
    private ListaMultasAdapter adapter;
    private Button botaoIndicarCondutor;

    private RecyclerView listaDeMultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_multas);

        listaDeMultas = findViewById(R.id.activity_consultar_multas_lista);

        TextView cpfUsuario = findViewById(R.id.activity_consultar_multas_cpf_usuario);
        cpfUsuario.setText("012.345.678-10");

        TextView cnhUsuario = findViewById(R.id.activity_consultar_multas_cnh_usuario);
        cnhUsuario.setText("987.654.321.00");

        botaoIndicarCondutor = findViewById(R.id.activity_consultar_multas_button_indicar);
        botaoIndicarCondutor.setOnClickListener(this);

        carregaTipoAcesso();

        recriaAdapter();
    }

    private void carregaTipoAcesso() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_TIPO_ACESSO)) {
            tipoAcesso = (String) intent.getSerializableExtra(CHAVE_TIPO_ACESSO);
        }
    }

    private void recriaAdapter() {
        getMultaRetornoExemplo();
        montaAdapter();
    }

    private void montaAdapter() {
        adapter = new ListaMultasAdapter(list, ConsultarMultasActivity.this);
        listaDeMultas.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setOnLongClickListener(this);
//        View footer = new View(ConsultarMultasActivity.this);
//        footer.setLayoutParams( new AbsListView.LayoutParams( RecyclerView.LayoutParams.FILL_PARENT, 100 ));
//        listaDeMultas.addFooterView(footer, null, false);
    }

    @NonNull
    private void getMultaRetornoExemplo() {
        list = new ArrayList<>();

        getMulta1();
        getMulta2();
        getMulta3();
        getMulta4();
        getMulta5();
    }

    private void getMulta1() {
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(1);
        multaRetorno.setDataInfracao(Calendar.getInstance());
        multaRetorno.setHoraInfracao(Calendar.getInstance());
        multaRetorno.setPlaca("BIT-0001");
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

    private void getMulta2() {
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(2);
        multaRetorno.setDataInfracao(Calendar.getInstance());
        multaRetorno.setHoraInfracao(Calendar.getInstance());
        multaRetorno.setPlaca("BIT-0002");
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

    private void getMulta3() {
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(3);
        multaRetorno.setDataInfracao(Calendar.getInstance());
        multaRetorno.setHoraInfracao(Calendar.getInstance());
        multaRetorno.setPlaca("BIT-0003");
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

    private void getMulta4() {
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(4);
        multaRetorno.setDataInfracao(Calendar.getInstance());
        multaRetorno.setHoraInfracao(Calendar.getInstance());
        multaRetorno.setPlaca("BIT-004");
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

    private void getMulta5() {
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(5);
        multaRetorno.setDataInfracao(Calendar.getInstance());
        multaRetorno.setHoraInfracao(Calendar.getInstance());
        multaRetorno.setPlaca("BIT-0005");
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

    @Override
    public void onItemClick(MultaRetorno multa) {
        if (multa != null) {
            Intent intentResumoMulta = new Intent(ConsultarMultasActivity.this, ResumoMultaActivity.class);
            intentResumoMulta.putExtra(CHAVE_MULTA_RETORNO, multa);
            intentResumoMulta.putExtra(CHAVE_TIPO_ACESSO, tipoAcesso);
            startActivityForResult(intentResumoMulta, INDICAR_CONDUTOR);
        }
    }

    @Override
    public void onLongClick(List<MultaRetorno> multas) {
        Log.e("onLongClick", "onLongClick");
        if (!multas.isEmpty()) {
            habilitaBotaoIndicarCondutor();
            Log.e("Multas", "List<multa>: " + multas.size());
            for (MultaRetorno multaRetorno : multas) {
                Log.e("Multas", "ids: " + multaRetorno.getId());
            }
        } else {
            desabilitaBotaoIndicarCondutor();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intentIndicarCondutor = new Intent(ConsultarMultasActivity.this, IndicacaoCondutorActivity.class);
        startActivityForResult(intentIndicarCondutor, INDICAR_CONDUTOR);
    }

    private void desabilitaBotaoIndicarCondutor() {
        botaoIndicarCondutor.setVisibility(View.GONE);
    }

    private void habilitaBotaoIndicarCondutor() {
        botaoIndicarCondutor.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INDICAR_CONDUTOR && resultCode == RESULT_OK) {
            recriaAdapter();
//            adapter.deselecionaTodos();
//            adapter.notifyDataSetChanged();
        }
    }
}
