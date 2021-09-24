package maxmilhas.com.br.marvelproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.entity.Constants;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.MarvelService;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.entity.Data;
import maxmilhas.com.br.marvelproject.model.api.entity.Response;
import maxmilhas.com.br.marvelproject.model.api.entity.Results;
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

        final Context context = this;
        final ListaCharactersView[] charactersView = {null};

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://gateway.marvel.com/v1/public/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        Constants constants = new Constants();
        String ts = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        String API_KEY = constants.getAPI_KEY();
        String hash = constants.getHASH();
        MarvelService service = retrofit.create(MarvelService.class);

        Call call = service.getAllCharacters(ts, API_KEY, hash);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {
                if(response.isSuccessful()){
                    Log.d("a", "Deu acesso");
                    Data data = response.body();
                    Results results = data.getResults();
                    List<Character> characters = results.getResults();

                    try {
                        charactersView[0] = new ListaCharactersView(context);
                        RecyclerView listCharacters = findViewById(R.id.list_characters_recyclerview);
                        charactersView[0].configAdapter(listCharacters);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                        listCharacters.setLayoutManager(layoutManager);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(context, "Ocorreu um erro na requisição", Toast.LENGTH_SHORT).show();
            }
        });

        setTitle("Characters");


    }
}
