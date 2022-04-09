package maxmilhas.com.br.marvelproject.ui;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.ui.recyclerview.adapter.ListaCharactersAdapter;

public class ListaCharactersView {

    private Context context;
    private final ListaCharactersAdapter adapter;

    public ListaCharactersView(Context context, List<Character> characters) {
        this.context = context;
        this.adapter = new ListaCharactersAdapter(context, characters);
    }

    public void configAdapter(RecyclerView listaDeCharacter){
        listaDeCharacter.setAdapter(adapter);
    }
}


