package maxmilhas.com.br.marvelproject.model.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("{characters}")
    Call getAllCharacters( @Query("ts") String ts ,@Query("apikey") String apiKey, @Query("hash") String hash);

}
