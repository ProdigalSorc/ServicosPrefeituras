package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities.intefaces.InterfacesActivityConstantes.CHAVE_TIPO_ACESSO;


public class DadosVeiculoActivity extends BaseActivity {

    EditText etRenavam;
    EditText etPlaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_veiculo);

        etRenavam = findViewById(R.id.activity_dados_veiculo_renavam);
        etPlaca = findViewById(R.id.activity_dados_veiculo_placa);
        Button btnOk = findViewById(R.id.activity_dados_veiculo_btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaListarMultas();
            }
        });
    }

    private void vaiParaListarMultas() {
        Intent intentListarMultas = new Intent(DadosVeiculoActivity.this, ConsultarMultasActivity.class);
        intentListarMultas.putExtra(CHAVE_TIPO_ACESSO, Constantes.TIPO_ACESSO_RENAVAM);
        startActivity(intentListarMultas);
        finish();
    }
}
