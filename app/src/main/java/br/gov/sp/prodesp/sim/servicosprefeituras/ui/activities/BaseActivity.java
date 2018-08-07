package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        setResultCancelar();
    }

    public void setResultCancelar() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    public void setResultOK() {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
