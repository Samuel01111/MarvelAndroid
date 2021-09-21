package maxmilhas.com.br.marvelproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.io.IOException;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.ui.ListaCharactersView;

public class ListaCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_characters);
        setTitle("Characters");
        ListaCharactersView charactersView = null;
        try {
            charactersView = new ListaCharactersView(this);
            RecyclerView listCharacters = findViewById(R.id.list_characters_recyclerview);
            charactersView.configAdapter(listCharacters);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            listCharacters.setLayoutManager(layoutManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
