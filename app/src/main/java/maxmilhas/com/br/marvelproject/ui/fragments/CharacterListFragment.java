package maxmilhas.com.br.marvelproject.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.repository.callback.AllCharactersCallbackInterface;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.repository.CharacterRepository;
import maxmilhas.com.br.marvelproject.ui.ListaCharactersView;

public class CharacterListFragment extends Fragment {

    public static CharacterListFragment newInstance() {
        Bundle args = new Bundle();
        CharacterListFragment fragment = new CharacterListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_lista_characters, container, false);
        setupRecyclerView(view.getContext());
        return view;
    }

    private void setupRecyclerView(Context context) {
        CharacterRepository characterRepository = new CharacterRepository();

        characterRepository.fetchAllCharacters(new AllCharactersCallbackInterface() {
                @Override
                public void onResponse(List<Character> characters) {
                    ListaCharactersView charactersView = new ListaCharactersView(context, characters);
                    RecyclerView listCharacters = getView().findViewById(R.id.list_characters_recyclerview);
                    charactersView.configAdapter(listCharacters);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    listCharacters.setLayoutManager(layoutManager);
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("Fail", t.getMessage() + "Error in the Requisition");
                }
            }
        );
    }
}

