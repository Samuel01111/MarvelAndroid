package maxmilhas.com.br.marvelproject.model.api.repository;

import android.util.Log;
import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.repository.callback.AllCharactersCallbackInterface;
import maxmilhas.com.br.marvelproject.model.api.MarvelService;
import maxmilhas.com.br.marvelproject.model.api.RetrofitBuilder;
import maxmilhas.com.br.marvelproject.model.api.entity.AccessApiKeys;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.entity.Data;
import maxmilhas.com.br.marvelproject.model.api.entity.DataDetails;
import maxmilhas.com.br.marvelproject.model.api.repository.callback.CharacterCallbackInterface;
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

    public void fetchAllCharacters(AllCharactersCallbackInterface allCharactersCallbackInterface){
        MarvelService service = retrofit.create(MarvelService.class);

        Call<Data> call = service.getAllCharacters(
                accessApiKeys.getApiKey(),
                accessApiKeys.getTs(),
                accessApiKeys.getHash()
        );

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {
                if(response.isSuccessful()) {
                    Log.d("Success", "Access Successfull");
                    Data data = response.body();
                    DataDetails results = data.getResults();
                    List<Character> characters = results.getResults();
                    allCharactersCallbackInterface.onResponse(characters);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                allCharactersCallbackInterface.onFailure(t);
            }
        });
    }

    public void fetchCharacter(int characterId , CharacterCallbackInterface characterCallbackInterface){
        MarvelService service = retrofit.create(MarvelService.class);

        Call<Data> call = service.getCharacterById(
                characterId,
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
                    characterCallbackInterface.onResponse(characters.get(0));
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                characterCallbackInterface.onFailure(t);
            }
        });
    }
}
