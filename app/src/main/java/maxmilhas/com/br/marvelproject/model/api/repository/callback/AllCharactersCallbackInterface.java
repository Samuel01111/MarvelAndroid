package maxmilhas.com.br.marvelproject.model.api.repository.callback;

import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;

public interface AllCharactersCallbackInterface {

    void onResponse(List<Character> characters);

    void onFailure(Throwable t);
}
