package maxmilhas.com.br.marvelproject.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.Serializable;

import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.model.api.repository.CharacterRepository;
import maxmilhas.com.br.marvelproject.model.api.repository.callback.CharacterCallbackInterface;

public class CharacterDetailFragment extends Fragment implements Serializable {

    public static CharacterDetailFragment newInstance(int characterId) {
        Bundle bundle = new Bundle();
        bundle.putInt("selectedId", characterId);
        CharacterDetailFragment fragment = new CharacterDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView fragmentName = view.findViewById(R.id.fragment_name);
        TextView fragmentDescription = view.findViewById(R.id.fragment_description);
        ImageView fragmentImage = view.findViewById(R.id.image);

        Bundle args = this.getArguments();
        int selectedCharacterInt = args.getInt("selectedId");
        CharacterRepository characterRepository = new CharacterRepository();

        characterRepository.fetchCharacter(selectedCharacterInt, new CharacterCallbackInterface() {
            @Override
            public void onResponse(Character character) {
                    fragmentName.setText(character.getName());
                    fragmentDescription.setText(character.getDescription());
                    Glide.with(getContext())
                            .load(character.getThumbnail().getLandscapeAmazing())
                            .into(fragmentImage);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Fail", t.getMessage() + "Error in the Requisition");
            }
        });
        return view;
    }
}
