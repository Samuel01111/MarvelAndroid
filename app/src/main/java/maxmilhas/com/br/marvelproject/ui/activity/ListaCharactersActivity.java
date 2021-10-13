package maxmilhas.com.br.marvelproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.List;
import maxmilhas.com.br.marvelproject.model.api.CharactersCallbackInterface;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.repository.CharacterRepository;
import maxmilhas.com.br.marvelproject.ui.ListaCharactersView;

public class ListaCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_characters);

        setupRecyclerView();
        setTitle("Characters");
    }

    public void setupRecyclerView() {
        Context context = this;

        CharacterRepository characterRepository = new CharacterRepository();

        characterRepository.fetchCharacters(new CharactersCallbackInterface() {
            @Override
            public void onResponse(List<Character> characters) {
                ListaCharactersView charactersView = new ListaCharactersView(context, characters);
                RecyclerView listCharacters = findViewById(R.id.list_characters_recyclerview);
                charactersView.configAdapter(listCharacters);
                LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                listCharacters.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Fail", t.getMessage() + "Error in the Requisition");
            }
        });
    }
}
