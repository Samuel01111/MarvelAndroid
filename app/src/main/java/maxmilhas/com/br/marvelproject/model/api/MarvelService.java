package maxmilhas.com.br.marvelproject.model.api;

import maxmilhas.com.br.marvelproject.model.api.entity.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("characters")
    Call<Data> getAllCharacters(@Query("apikey") String apiKey, @Query("ts") String ts, @Query("hash") String hash);

    @GET("characters/{characterId}")
    Call<Data> getCharacterById(@Path("characterId") int characterId, @Query("apikey") String apiKey, @Query("ts") String ts, @Query("hash") String hash);
}
