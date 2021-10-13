package maxmilhas.com.br.marvelproject.model.api;

import java.util.List;

import maxmilhas.com.br.marvelproject.model.api.entity.Character;

public interface CharactersCallbackInterface {

    void onResponse(List<Character> characters);

    void onFailure(Throwable t);
}
