package maxmilhas.com.br.marvelproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.ui.fragments.CharacterListFragment;

public class ListaCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.conteiner_root, CharacterListFragment.newInstance(), "characterList")
                    .commit();
        }

        setTitle("Characters");
    }


}
