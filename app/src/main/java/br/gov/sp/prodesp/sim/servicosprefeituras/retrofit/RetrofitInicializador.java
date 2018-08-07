package br.gov.sp.prodesp.sim.servicosprefeituras.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador(String baseUrl){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

//    public AlunoService getAlunoService() {
//        return retrofit.create(AlunoService.class);
//    }
//
//    public DispositivoService getDispositivoService() {
//        return retrofit.create(DispositivoService.class);
//    }
}
