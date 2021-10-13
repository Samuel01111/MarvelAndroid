package maxmilhas.com.br.marvelproject.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitBuilder {

    public Retrofit build(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gateway.marvel.com/v1/public/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        return retrofit;
    }
}
