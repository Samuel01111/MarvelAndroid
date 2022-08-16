package maxmilhas.com.br.marvelproject.ui.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;
import maxmilhas.com.br.marvelproject.ui.fragments.CharacterDetailFragment;

public class ListaCharactersAdapter extends RecyclerView.Adapter<ListaCharactersAdapter.CharacterViewHolder> {

    private Context context;
    private List<Character> characters;

    public ListaCharactersAdapter(Context context, List<Character> characters){
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        fillItemList(holder, position);

        holder.itemView.setOnClickListener(v -> {
            int characterId = characters.get(position).getId();

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.conteiner_root, CharacterDetailFragment.newInstance(characterId), "characterDetail")
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void fillItemList(@NonNull CharacterViewHolder holder, int position){
        Character character = characters.get(position);

        Glide.with(context)
                .load(character.getThumbnail().getStandardLarge())
                .into(holder.imageView);

        if (position % 2 == 0){
            holder.cardView.setCardBackgroundColor(holder.cardView.getResources().getColor(R.color.Red));
            holder.name.setTextColor(Color.WHITE);
            holder.description.setTextColor(holder.cardView.getResources().getColor(R.color.Gray));
        } else {
            holder.cardView.setCardBackgroundColor(holder.cardView.getResources().getColor(R.color.Gray));
            holder.name.setTextColor(Color.WHITE);
            holder.description.setTextColor(Color.LTGRAY);
        }
        holder.name.setText(character.getName());
        holder.description.setText(character.getDescription());
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        CardView cardView;
        ImageView imageView;
        ImageView fragmentImageView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.character_name);
            description = itemView.findViewById(R.id.character_description);
            cardView = itemView.findViewById(R.id.item_character);
            imageView = itemView.findViewById(R.id.image_character);
            fragmentImageView = itemView.findViewById(R.id.image);
        }
    }
}
