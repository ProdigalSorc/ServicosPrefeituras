package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        voltarCancelar();
    }

    public void voltarCancelar() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    public void voltarOK() {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
