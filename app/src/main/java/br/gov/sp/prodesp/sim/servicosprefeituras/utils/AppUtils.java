package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes.PERMISSIONS;
import static br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes.PERMISSION_CAMERA;

public class AppUtils {

    private static final String TAG_LOG = AppUtils.class.getSimpleName();

    public static boolean isAndroidMarshmallowOrSuperiorVersion() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static boolean hasPermission(Context context, String permission, int requestCode) {
        if (isAndroidMarshmallowOrSuperiorVersion()) {
            if (context.checkSelfPermission(permission)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG_LOG, "Permission is granted");
                return true;
            } else {
                Log.v(TAG_LOG, "Permission is revoked");
                requestPermission(context, new String[]{permission}, requestCode);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG_LOG, "Permission is granted");
            return true;
        }
    }

    public static void requestPermission(Context context, String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions((Activity) context, permissions, requestCode);
    }


    public static boolean hasPermissions(Context context, String[] permissions) {
        if (isAndroidMarshmallowOrSuperiorVersion()) {
            for (String permission : permissions) {
                if (context.checkSelfPermission(permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG_LOG, "Permission is granted");
        }
        return true;
    }

    public static void fecharSemLancarExcecao(final Closeable closeable) {
        if (closeable != null) {
            if (closeable instanceof Flushable) {
                try {
                    ((Flushable) closeable).flush();
                } catch (Exception e) {
                    Log.e(TAG_LOG, "Erro ao executar o 'flush' do recurso.", e);
                }
            }
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(TAG_LOG, "Erro ao executar o fechar recurso.", e);
            }
        }
    }

    public static String[] getPermission(Context context) {
        return notPermited(context, PERMISSIONS).toArray(new String[0]);
    }

    public static List<String> notPermited(Context context, String[] permissions) {
        List<String> returnNotPermited = new ArrayList<>();
        if (isAndroidMarshmallowOrSuperiorVersion()) {
            for (String permission : permissions) {
                if (context.checkSelfPermission(permission)
                        == PackageManager.PERMISSION_DENIED) {
                    returnNotPermited.add(permission);
                }
            }
        }
        Log.v(TAG_LOG, "returnNotPermited - " + returnNotPermited.toString());
        return returnNotPermited;
    }

}
