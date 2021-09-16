package maxmilhas.com.br.marvelproject.ui.recyclerview.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.Character;

public class ListaCharactersAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Character> characters;

    public ListaCharactersAdapter(Context context, List<Character> characters){
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Character character = characters.get(position);
        TextView name = holder.itemView.findViewById(R.id.character_name);
        TextView description = holder.itemView.findViewById(R.id.character_description);

        name.setText(character.getName());
        description.setText(character.getDescription());

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
