package maxmilhas.com.br.marvelproject.model.api.repository.callback;

import java.util.List;

import maxmilhas.com.br.marvelproject.model.api.entity.Character;

public interface CharacterCallbackInterface {

    void onResponse(Character character);

    void onFailure(Throwable t);
}
