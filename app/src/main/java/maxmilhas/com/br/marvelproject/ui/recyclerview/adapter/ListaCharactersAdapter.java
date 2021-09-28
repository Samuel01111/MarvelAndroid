package maxmilhas.com.br.marvelproject.ui.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
import maxmilhas.com.br.marvelproject.ui.activity.ListaCharactersActivity;

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
        fillViews(holder, position);

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void fillViews(@NonNull RecyclerView.ViewHolder holder, int position){
        Character character = characters.get(position);

        TextView name = holder.itemView.findViewById(R.id.character_name);
        TextView description =  holder.itemView.findViewById(R.id.character_description);
        CardView cardView = holder.itemView.findViewById(R.id.item_character);
        ImageView imageView = holder.itemView.findViewById(R.id.image_character);

        Glide.with(context)
                .load(character.getThumbnail().getStandardMedium())
                .into(imageView);

        if (character.getId() % 2 == 0){
            cardView.setCardBackgroundColor(getRedColor());
            name.setTextColor(Color.WHITE);
            description.setTextColor(getGrayColor());
        } else {
            cardView.setCardBackgroundColor(Color.DKGRAY);
            name.setTextColor(Color.WHITE);
            description.setTextColor(Color.LTGRAY);
        }
        name.setText(character.getName());
        description.setText(character.getDescription());



//        fun ImageView.load(url: String) {
//            Glide.with(context)
//                    .load(url)
//                    .into(this);
//        }
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


        }

    }
    public String a(){
        return "a";
    }
}
