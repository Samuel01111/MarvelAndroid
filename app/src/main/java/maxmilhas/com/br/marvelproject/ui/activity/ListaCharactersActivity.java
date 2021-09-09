package maxmilhas.com.br.marvelproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.ui.ListaCharactersView;

public class ListaCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_characters);
        ListaCharactersView charactersView = new ListaCharactersView(this);
        ListView listCharacters = findViewById(R.id.list_characters);
        charactersView.configAdapter(listCharacters);
    }
}
