package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class CameraUtils {

    private static int tamanhoMaximoFoto = 358400;

    public static String armazenarFoto(String caminhoFoto, String chaveCriptografia) {
        Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
        ByteArrayOutputStream bos = reduceSize(bitmap, tamanhoMaximoFoto);
//        String chaveCriptografia = ContextoSeguranca.getInstancia(getApplicationContext()).getChaveBancoDados();
        return FileUtil.encryptFile(caminhoFoto, chaveCriptografia, bos);
    }

    private static ByteArrayOutputStream reduceSize(Bitmap bitmap, int tamanhoEmBytes) {
        ByteArrayOutputStream bos;
        Bitmap bitmapReduzido = bitmap;
        int maxIteracoes = 10;
        int iteracao = 1;
        int reducaoWidth = (int) Math.round(bitmapReduzido.getWidth() * 0.15);
        int reducaoHeight = (int) Math.round(bitmapReduzido.getHeight() * 0.15);
        int width;
        int height;
        if (tamanhoEmBytes <= 0) tamanhoEmBytes = 1024 * 500; // Default = 500 Kb

        do {
            bos = new ByteArrayOutputStream();
            width = bitmapReduzido.getWidth() - reducaoWidth;
            height = bitmapReduzido.getHeight() - reducaoHeight;
            if (width <= 0 || height <= 0) {
                break;
            }
            bitmapReduzido = Bitmap.createScaledBitmap(bitmapReduzido, width, height, true);
            bitmapReduzido.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        } while (bos.size() > tamanhoEmBytes && maxIteracoes > iteracao++);

        return bos;
    }
}
