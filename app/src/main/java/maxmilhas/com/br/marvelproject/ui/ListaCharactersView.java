package maxmilhas.com.br.marvelproject.ui;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.ui.recyclerview.adapter.ListaCharactersAdapter;

public class ListaCharactersView {

    private Context context;
    private final ListaCharactersAdapter adapter;

    public ListaCharactersView(Context context) throws IOException, IOException {

        this.context = context;

        Moshi moshi = new Moshi.Builder().build();
        String file = "character.json";
        InputStream is = context.getAssets().open(file);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        String jsonString = new String(buffer, "UTF-8");
        Type type = Types.newParameterizedType(List.class, Character.class);
        JsonAdapter<List<Character>> jsonAdapter = moshi.adapter(type);
        List<Character> characters = jsonAdapter.fromJson(jsonString);




        this.adapter = new ListaCharactersAdapter(context, characters);
    }

    public void configAdapter(RecyclerView listaDeCharacter){
        listaDeCharacter.setAdapter(adapter);
    }

}


