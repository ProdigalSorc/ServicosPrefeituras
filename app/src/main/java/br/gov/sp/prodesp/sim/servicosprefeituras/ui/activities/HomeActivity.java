package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.intefaces.PacoteActivityConstantes.CHAVE_TIPO_ACESSO;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView mIndicarCondutor = findViewById(R.id.home_imagem_indicar_condutor);
        mIndicarCondutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - Incluir tratamento, caso o login não tenha sido realizado
                vaiParaCpfCnpjLogin();
            }
        });

        ImageView mConsultarMultas = findViewById(R.id.home_imagem_consultar_multas);
        mConsultarMultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - Incluir tratamento, caso o login não tenha sido realizado
                vaiParaDadosVeiculo();
            }
        });
    }

    private void vaiParaCpfCnpjLogin() {
        Intent intentIndicarCondutor = new Intent(HomeActivity.this, CpfCnpjLoginActivity.class );
        startActivity(intentIndicarCondutor);
    }

    private void vaiParaDadosVeiculo() {
        Intent intentDadodsVeiculo = new Intent(HomeActivity.this, DadosVeiculoActivity.class );
        startActivity(intentDadodsVeiculo);
    }
}
