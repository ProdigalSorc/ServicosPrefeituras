package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
    public static int DEFAULT_BUFFER_SIZE = 20;

    public static void save(byte[] input, File fileOutput) throws IOException {
        save(input, fileOutput, DEFAULT_BUFFER_SIZE);
    }

    public static void save(byte[] input, File fileOutput, int bufSize) throws IOException {
        BufferedOutputStream out = null;
        try {
            OutputStream fout = new FileOutputStream(fileOutput);
            out = new BufferedOutputStream(fout, bufSize);
            out.write(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            AppUtils.fecharSemLancarExcecao(out);
        }
    }

    public static byte[] read(File fileInput) throws IOException {
        return read(fileInput, DEFAULT_BUFFER_SIZE);
    }

    public static byte[] read(File fileInput, int bufSize) throws IOException {
        return read(new FileInputStream(fileInput), bufSize);
    }

    public static byte[] read(InputStream in) throws IOException {
        return read(in, DEFAULT_BUFFER_SIZE);
    }

    public static byte[] read(InputStream in, int bufSize) throws IOException {
        try {
            byte[] buffer = new byte[bufSize];
            ByteArrayOutputStream ba = new ByteArrayOutputStream(bufSize);
            int read;
            while((read = in.read(buffer, 0, bufSize)) > 0) {
                ba.write(buffer, 0, read);
            }
            return ba.toByteArray();
        } catch (IOException e) {
            throw new IOException(e);
        } finally{
            AppUtils.fecharSemLancarExcecao(in);
        }
    }
}
