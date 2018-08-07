package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.gov.sp.prodesp.sim.servicosprefeituras.BuildConfig;

public class FileUtil {
    public static Uri getUri(Context context, File file) {
        Uri uri;
        if (AppUtils.isAndroidMarshmallowOrSuperiorVersion()) {
            uri = getUriFrom(context, file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    private static Uri getUriFrom(Context context, File file) {
        return FileProvider.getUriForFile(context, getAuthority(), file);
    }

    @NonNull
    private static String getAuthority() {
        return BuildConfig.APPLICATION_ID + ".provider";
    }

    public static void removeFileFrom(String path) {
        File arquivoImagem = new File(path);
        if (arquivoImagem.exists()) {
            arquivoImagem.delete();
        }
    }

    public static String encryptFile(String imageFileName, String chaveCriptografia, ByteArrayOutputStream out) {
        File fileCripto = new File(imageFileName + ".cripto");
        FileOutputStream outCripto = null;

        try {
            outCripto = new FileOutputStream(fileCripto);
            outCripto.write(CryptUtils.enc(out.toByteArray(), chaveCriptografia.getBytes()));
            outCripto.flush();
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        } finally {
            AppUtils.fecharSemLancarExcecao(out);
            AppUtils.fecharSemLancarExcecao(outCripto);
            try {
                if (outCripto != null) {
                    outCripto.close();
                }
            } catch (IOException e) {
                Log.e("IOException", e.getMessage());
            }
        }

        return fileCripto.getAbsolutePath();
    }

    public static byte[] decryptFile(String path, String chaveCriptografia) throws IOException {
        File file = new File(path);
        byte bytesImagemCripto[] = IOUtils.read(file);
        return CryptUtils.dec(bytesImagemCripto, chaveCriptografia.getBytes());
    }
}
