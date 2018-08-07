package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.util.Log;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class CryptUtils {
    private static final String TAG_LOG = CryptUtils.class.getSimpleName();
    public static String DEFAULT_ALGORITHM = "AES";

    public static byte[] dec(byte[] encrypted, byte[] keyBytes) throws CryptException {
        return dec(encrypted, keyBytes, DEFAULT_ALGORITHM);
    }

    private static byte[] fixKey(byte[] keyBytes, String algorithm){
        if(algorithm.equals(DEFAULT_ALGORITHM) && keyBytes.length != 16 && keyBytes.length != 24 && keyBytes.length != 32){
            Log.i(TAG_LOG, "Ajustando chave de criptografia...");
            int padding = 16;

            if(keyBytes.length > 24)
                padding = 32;
            else if(keyBytes.length > 16)
                padding = 24;

            keyBytes = copyOf(keyBytes, padding);
        }

        return keyBytes;
    }

    public static byte[] dec(byte[] encrypted, byte[] keyBytes, String algorithm) throws CryptException{

        keyBytes = fixKey(keyBytes, algorithm);

        byte[] decrypted;
        int dec_len;
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

            cipher.init(Cipher.DECRYPT_MODE, key, (IvParameterSpec)null);
            decrypted = new byte[cipher.getOutputSize(encrypted.length)];
            dec_len = cipher.update(encrypted, 0, encrypted.length, decrypted, 0);
            dec_len += cipher.doFinal(decrypted, dec_len);
        } catch (BadPaddingException e) {
            throw new CryptException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        decrypted = copyOf(decrypted, dec_len);

        return decrypted;
    }

    public static byte[] enc(byte[] input, byte[] keyBytes){
        return enc(input, keyBytes, DEFAULT_ALGORITHM);
    }

    public static byte[] enc(byte[] input, byte[] keyBytes, String algorithm){
        keyBytes = fixKey(keyBytes, algorithm);
        byte[] encrypted;
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key, (IvParameterSpec)null);
            encrypted = new byte[cipher.getOutputSize(input.length)];
            int enc_len = cipher.update(input, 0, input.length, encrypted, 0);
            enc_len += cipher.doFinal(encrypted, enc_len);
            encrypted = copyOf(encrypted, enc_len);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return encrypted;
    }

    private static byte[] copyOf(byte[] origin, int length){
        if(length == origin.length)
            return origin;

        int top = length;

        if(origin.length < top)
            top = origin.length;

        byte[] dec = new byte[length];
        for (int i=0; i < top; i++)
            dec[i] = origin[i];

        return dec;
    }
}

