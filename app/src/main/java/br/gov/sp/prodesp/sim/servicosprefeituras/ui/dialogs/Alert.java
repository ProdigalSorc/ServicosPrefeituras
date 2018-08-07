package br.gov.sp.prodesp.sim.servicosprefeituras.ui.dialogs;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.Html;

import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;

public class Alert {
    public static void mostrarDialogSimples(String message, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setTitle(Constantes.ALERT_AVISO);
        builder.setPositiveButton(Constantes.ALERT_OK, null);
        builder.show();
    }

}
