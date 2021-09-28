package maxmilhas.com.br.marvelproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import maxmilhas.com.br.marvelproject.extentions.*;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import maxmilhas.com.br.marvelproject.model.api.entity.Constants;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.MarvelService;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.entity.Data;
import maxmilhas.com.br.marvelproject.model.api.entity.DataDetails;
import maxmilhas.com.br.marvelproject.ui.ListaCharactersView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ListaCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_characters);
        Locale.setDefault(Locale.ENGLISH);

        Context context = this;

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gateway.marvel.com/v1/public/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        Log.d("a", "https://gateway.marvel.com/v1/public/characters?apikey=" + getApi_key() + "&ts=" + getTs() +  "&hash=" + getHash());

        MarvelService service = retrofit.create(MarvelService.class);

        Call<Data> call = service.getAllCharacters(getApi_key(), getTs(), getHash());

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {
                if(response.isSuccessful()){
                    Log.d("Success", "Access Successfull");
                    Data data = response.body();
                    DataDetails results = data.getResults();
                    List<Character> characters = results.getResults();

                    try {
                        ListaCharactersView charactersView = new ListaCharactersView(context, characters);
                        RecyclerView listCharacters = findViewById(R.id.list_characters_recyclerview);
                        charactersView.configAdapter(listCharacters);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                        listCharacters.setLayoutManager(layoutManager);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("Fail", t.getMessage() + "Error in the Requisition");
            }
        });
        setTitle("Characters");
    }

    Constants constants = new Constants();

    public String getTs(){
       // String.valueOf(System.currentTimeMillis() / 1000

        return "1632441614";
    }

    public String getApi_key(){
        return constants.getAPI_KEY();
    }

    public String getPrivate_key(){
        return constants.getPRIVATE_KEY();
    }

    public String getHash(){
        StringUtils stringUtils = new StringUtils();
        String hashUtil = (getTs() + getPrivate_key() + getApi_key());
        return stringUtils.md5(hashUtil);
    }

}
