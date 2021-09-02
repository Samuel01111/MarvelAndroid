package maxmilhas.com.br.marvelproject.ui;

import android.content.Context;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import maxmilhas.com.br.marvelproject.model.Character;
import maxmilhas.com.br.marvelproject.ui.adapter.ListaCharactersAdapter;

public class ListaCharactersView {

    private final ListaCharactersAdapter adapter;
    private final Context context;
    Character ch = new Character("huck", "huck.picture.com/picture", "Im strong");
    private List<Character> characters =  Arrays.asList(ch);

    public ListaCharactersView(Context context) {
        this.context = context;
        this.adapter = new ListaCharactersAdapter(this.context, characters);

    }
    public void configAdapter(ListView listaDeCharacter){
        listaDeCharacter.setAdapter(adapter);
    }
}


