package maxmilhas.com.br.marvelproject.model.api.repository;

import android.util.Log;
import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.CharactersCallbackInterface;
import maxmilhas.com.br.marvelproject.model.api.MarvelService;
import maxmilhas.com.br.marvelproject.model.api.RetrofitBuilder;
import maxmilhas.com.br.marvelproject.model.api.entity.AccessApiKeys;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.entity.Data;
import maxmilhas.com.br.marvelproject.model.api.entity.DataDetails;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class CharacterRepository {

    private Retrofit retrofit;
    private AccessApiKeys accessApiKeys;

    public CharacterRepository(){
        retrofit = new RetrofitBuilder().build();
        accessApiKeys = new AccessApiKeys();
    }

    public void fetchCharacters(CharactersCallbackInterface charactersCallbackInterface){
        MarvelService service = retrofit.create(MarvelService.class);

        Call<Data> call = service.getAllCharacters(
                accessApiKeys.getApiKey(),
                accessApiKeys.getTs(),
                accessApiKeys.getHash()
        );

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {
                if(response.isSuccessful()){
                    Log.d("Success", "Access Successfull");
                    Data data = response.body();
                    DataDetails results = data.getResults();
                    List<Character> characters = results.getResults();
                    charactersCallbackInterface.onResponse(characters);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                charactersCallbackInterface.onFailure(t);
            }
        });
    }
}
