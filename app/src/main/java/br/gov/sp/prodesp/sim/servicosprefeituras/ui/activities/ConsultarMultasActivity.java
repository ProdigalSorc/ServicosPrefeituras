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
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.DataUtil;

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
        desabilitaBotaoIndicarCondutor();
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
//        getMulta5();
    }

    private void getMulta1() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DataUtil.strToDateTime("15/07/2018 11:00"));
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(1);
        multaRetorno.setNumAit("0011");
        multaRetorno.setSerie("C");
        multaRetorno.setOrgaoAutuador("Prefeitura de Suzano");
        multaRetorno.setDataInfracao(calendar);
        multaRetorno.setHoraInfracao(calendar);
        multaRetorno.setPlaca("BIT-0010");
        multaRetorno.setMarca("Gol 1.0");
        multaRetorno.setEspecie("Passageiro");
        multaRetorno.setNomeProprietario("José da Silva");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(DataUtil.strToDateTime("20/07/2018 11:00"));
        multaRetorno.setDataEmissao(calendar1);

        multaRetorno.setDescricaoInfracao("Avançar o sinal vermelho do semáforo");
        multaRetorno.setEnquadramento("605-0");
        multaRetorno.setLocalInfracao("Rua Nascente");
        multaRetorno.setPontosCnh("5");

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(DataUtil.strToDateTime("20/08/2018 11:00"));
        multaRetorno.setDataLimite(calendar2);

        multaRetorno.setSituacaoMultaEnum(SituacaoMultaEnum.AIT_AGUARDANDO);
        list.add(multaRetorno);
    }

    private void getMulta2() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DataUtil.strToDateTime("15/07/2018 12:00"));
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(2);
        multaRetorno.setNumAit("0012");
        multaRetorno.setSerie("C");
        multaRetorno.setOrgaoAutuador("Prefeitura de Suzano");
        multaRetorno.setDataInfracao(calendar);
        multaRetorno.setHoraInfracao(calendar);
        multaRetorno.setPlaca("BIT-0010");
        multaRetorno.setMarca("Gol 1.0");
        multaRetorno.setEspecie("Passageiro");
        multaRetorno.setNomeProprietario("José da Silva");

        calendar.setTime(DataUtil.strToDateTime("20/07/2018 11:00"));
        multaRetorno.setDataEmissao(calendar);

        multaRetorno.setDescricaoInfracao("Permitir posse/conducao do veiculo a pessoa sem usar lentes corretoras de visao");
        multaRetorno.setEnquadramento("715-1");
        multaRetorno.setLocalInfracao("Rua Nascente");
        multaRetorno.setPontosCnh("7");

        calendar.setTime(DataUtil.strToDateTime("20/08/2018 11:00"));
        multaRetorno.setDataLimite(calendar);

        multaRetorno.setSituacaoMultaEnum(SituacaoMultaEnum.AIT_AGUARDANDO);
        list.add(multaRetorno);
    }


    private void getMulta3() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DataUtil.strToDateTime("20/07/2018 17:50"));
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(3);
        multaRetorno.setNumAit("0013");
        multaRetorno.setSerie("C");
        multaRetorno.setOrgaoAutuador("Prefeitura de Suzano");
        multaRetorno.setDataInfracao(calendar);
        multaRetorno.setHoraInfracao(calendar);
        multaRetorno.setPlaca("BIT-0010");
        multaRetorno.setMarca("Gol 1.0");
        multaRetorno.setEspecie("Passageiro");
        multaRetorno.setNomeProprietario("José da Silva");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(DataUtil.strToDateTime("30/07/2018 11:00"));
        multaRetorno.setDataEmissao(calendar1);

        multaRetorno.setDescricaoInfracao("Avançar o sinal vermelho do semáforo");
        multaRetorno.setEnquadramento("605-0");
        multaRetorno.setLocalInfracao("Rua Professor Nestor");
        multaRetorno.setPontosCnh("5");

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(DataUtil.strToDateTime("30/08/2018 11:00"));
        multaRetorno.setDataLimite(calendar2);

        multaRetorno.setSituacaoMultaEnum(SituacaoMultaEnum.AIT_AGUARDANDO);
        list.add(multaRetorno);
    }

    private void getMulta4() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DataUtil.strToDateTime("01/08/2018 10:20"));
        MultaRetorno multaRetorno = new MultaRetorno();
        multaRetorno.setId(4);
        multaRetorno.setNumAit("0014");
        multaRetorno.setSerie("C");
        multaRetorno.setOrgaoAutuador("Prefeitura de Itu");
        multaRetorno.setDataInfracao(calendar);
        multaRetorno.setHoraInfracao(calendar);
        multaRetorno.setPlaca("BIT-0010");
        multaRetorno.setMarca("Gol 1.0");
        multaRetorno.setEspecie("Passageiro");
        multaRetorno.setNomeProprietario("José da Silva");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(DataUtil.strToDateTime("10/08/2018 11:00"));
        multaRetorno.setDataEmissao(calendar1);

        multaRetorno.setDescricaoInfracao("Avançar o sinal vermelho do semáforo");
        multaRetorno.setEnquadramento("605-0");
        multaRetorno.setLocalInfracao("Rua Sabino");
        multaRetorno.setPontosCnh("5");

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(DataUtil.strToDateTime("10/09/2018 11:00"));
        multaRetorno.setDataLimite(calendar2);

        multaRetorno.setSituacaoMultaEnum(SituacaoMultaEnum.AIT_AGUARDANDO);
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
        Intent intentIndicarCondutor = new Intent(ConsultarMultasActivity.this, IndicacaoActivity.class);
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
