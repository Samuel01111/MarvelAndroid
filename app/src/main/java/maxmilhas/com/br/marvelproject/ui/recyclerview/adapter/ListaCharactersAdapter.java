package maxmilhas.com.br.marvelproject.ui.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.api.entity.Character;

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
        fillViews(holder, position);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void fillViews(@NonNull CharacterViewHolder holder, int position){
        Character character = characters.get(position);

        Glide.with(context)
                .load(character.getThumbnail().getStandardMedium())
                .into(holder.imageView);

        if (position % 2 == 0){
            holder.cardView.setCardBackgroundColor(holder.cardView.getResources().getColor(R.color.Red));
            holder.name.setTextColor(Color.WHITE);
            holder.description.setTextColor(getGrayColor());
        } else {
            holder.cardView.setCardBackgroundColor(holder.cardView.getResources().getColor(R.color.Gray));
            holder.name.setTextColor(Color.WHITE);
            holder.description.setTextColor(Color.LTGRAY);
        }
        holder.name.setText(character.getName());
        holder.description.setText(character.getDescription());


    }

    public int getRedColor(){
        return Color.rgb(255, 86, 74);
    }
    public int getGrayColor(){
        return Color.rgb(59, 59, 59);
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        CardView cardView;
        ImageView imageView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.character_name);
            description =  itemView.findViewById(R.id.character_description);
            cardView = itemView.findViewById(R.id.item_character);
            imageView = itemView.findViewById(R.id.image_character);
        }
    }
}

