package maxmilhas.com.br.marvelproject.ui;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.Character;
import maxmilhas.com.br.marvelproject.ui.recyclerview.adapter.ListaCharactersAdapter;

public class ListaCharactersView {

    private final Context context;
    private final ListaCharactersAdapter adapter;
    File fileName = new File("character.json");
    String myJson = new Scanner(new File(String.valueOf(fileName))).useDelimiter("\\z").next();

    Moshi moshi = new Moshi.Builder().build();
    Type type = Types.newParameterizedType(List.class, Character.class);
    JsonAdapter<List<Character>> adapterJson = moshi.adapter(type);
    List<Character> charactersFromJson = adapterJson.

    {
        try {
            charactersFromJson = adapterJson.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    Character huck = new Character(1 ,"Huck", "huck.picture.com/picture", "Im strong and that's it teste teste teste test test test test teste tesdtye");
    Character thor = new Character(2 ,"Thor", "thor.picture.com/picture", "We are strong and that's it");
    Character spider = new Character(3 ,"Spider-Man", "spider_man.picture.com/picture", "He is strong and that's it");
    Character cap = new Character(4 ,"Captain America", "captain_america.picture.com/picture", "She is strong and that's it");
    Character iron = new Character(5 ,"Iron Man", "iron_man.picture.com/picture", "They are strong and that's it");
//    Character huck1 = new Character("Huck", "huck.picture.com/picture", "Im strong and that's it teste teste teste test test test test teste tesdtye");
//    Character thor2 = new Character("Thor", "thor.picture.com/picture", "We are strong and that's it");
//    Character spider3 = new Character("Spider-Man", "spider_man.picture.com/picture", "He is strong and that's it");
//    Character cap4 = new Character("Captain America", "captain_america.picture.com/picture", "She is strong and that's it");
//    Character iron5 = new Character("Iron Man", "iron_man.picture.com/picture", "They are strong and that's it");

    private List<Character> characters = charactersFromJson;


    public ListaCharactersView(Context context) throws IOException, IOException {
        this.context = context;
        this.adapter = new ListaCharactersAdapter(this.context, characters);
    }

    public void configAdapter(RecyclerView listaDeCharacter){
        listaDeCharacter.setAdapter(adapter);
    }


}


