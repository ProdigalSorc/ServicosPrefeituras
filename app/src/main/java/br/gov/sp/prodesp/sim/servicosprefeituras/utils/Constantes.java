package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.Manifest;

public class Constantes {

    //    URL's
    public static final String URL_RECURSO = "http://desenv.mobile.sp.gov.br/detranpoc.api/api/p/cnh/recurso";

    public static  final String URL_BASE = "http://mobile.sp.gov.br/detransim.api/api/p/condutor";
//    public static  final String URL_BASE = "http://desenv.mobile.sp.gov.br/detransim.api/api/p/condutor";
//    public static  final String URL_BASE = http://10.2.1.56:8080/detransim.api/api/p/condutor";

    public static  final String BUSCAR_PONTUACAO_PF = "/pontuacao/cpf/";
    public static  final String BUSCAR_PONTUACAO_PJ = "/pontuacao/cnpj/";
    public static  final String BUSCAR_PONTUACAO_PJ_PLACA = "/placa/";
    public static  final String BUSCAR_NOME_INFRATOR = "/indicado/cnpjcpf/";
    public static  final String BUSCAR_NOME_INFRATOR_CNH = "/cnh/";
    public static  final String INDICAR = "/indicacao";
    public static  final String INDICAR_PJ = "/formulario";


    public static final String WS_USER = "detranpoc";
    public static final String WS_PASS = "#detran$";

    public static final String TIPO_ACESSO_RENAVAM = "TIPO_ACESSO_RENAVAM";
    public static final String TIPO_ACESSO_CPF = "TIPO_ACESSO_CPF";
    public static final int CAMERA_REQUEST_FOTO_1 = 1;
    public static final String ALERT_OK = "OK";
    public static final String ALERT_AVISO = "Aviso";
    public static String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    public static String PERMISSIONS_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static String[] PERMISSIONS = {PERMISSIONS_STORAGE, READ_PHONE_STATE, PERMISSION_CAMERA};
    public static int PERMISSION_ALL = 1;

    public static String chaveCriptografia = "FmrlzUQHUxRljmLd";
}
