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
    Character huck = new Character("Huck", "huck.picture.com/picture", "Im strong and that's it teste teste teste test test test test teste tesdtye");
    Character thor = new Character("Thor", "thor.picture.com/picture", "We are strong and that's it");
    Character spider = new Character("Spider-Man", "spider_man.picture.com/picture", "He is strong and that's it");
    Character cap = new Character("Captain America", "captain_america.picture.com/picture", "She is strong and that's it");
    Character iron = new Character("Iron Man", "iron_man.picture.com/picture", "They are strong and that's it");
    private List<Character> characters =  Arrays.asList(huck, thor, spider, cap, iron);

    public ListaCharactersView(Context context) {
        this.context = context;
        this.adapter = new ListaCharactersAdapter(this.context, characters);
    }
    public void configAdapter(ListView listaDeCharacter){
        listaDeCharacter.setAdapter(adapter);
    }
}


