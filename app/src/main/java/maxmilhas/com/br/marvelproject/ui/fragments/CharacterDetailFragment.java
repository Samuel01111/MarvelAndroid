package maxmilhas.com.br.marvelproject.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import maxmilhas.com.br.marvelproject.R;

public class CharacterDetailFragment extends Fragment {

    public static CharacterDetailFragment newInstance() {
        Bundle args = new Bundle();

        CharacterDetailFragment fragment = new CharacterDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_detail, container, false);

    }


}