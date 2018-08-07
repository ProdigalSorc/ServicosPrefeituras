package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;

import static br.gov.sp.prodesp.sim.servicosprefeituras.ui.intefaces.PacoteActivityConstantes.CHAVE_TIPO_ACESSO;

public class CpfCnpjLoginActivity extends BaseActivity {

    private EditText mCpfCnpj;
    private EditText mPasswordView;
    private String tipoAcesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpf_cnpj_login);
        mCpfCnpj = findViewById(R.id.activity_login_cpf_cnpj);
        mPasswordView = findViewById(R.id.activity_login_password);
        Button btnLogin = findViewById(R.id.activity_login_btn_login);
        carregaTipoAcesso();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaPermissao();
            }
        });
    }

    private void validaPermissao() {
        if (tipoAcesso != null && tipoAcesso.equals(Constantes.TIPO_ACESSO_RENAVAM)) {
            finish();
        } else {
            vaiParaConsultarMultas();
        }
    }

    private void vaiParaConsultarMultas() {
        Intent intentConsultarMultas = new Intent(CpfCnpjLoginActivity.this, ConsultarMultasActivity.class);
        intentConsultarMultas.putExtra(CHAVE_TIPO_ACESSO, Constantes.TIPO_ACESSO_CPF);
        startActivity(intentConsultarMultas);
        finish();
    }


    private void carregaTipoAcesso() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_TIPO_ACESSO)) {
            tipoAcesso = (String) intent.getSerializableExtra(CHAVE_TIPO_ACESSO);
        }
    }
}

