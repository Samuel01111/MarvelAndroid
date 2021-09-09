package maxmilhas.com.br.marvelproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import maxmilhas.com.br.marvelproject.R;
import maxmilhas.com.br.marvelproject.model.Character;

public class ListaCharactersAdapter extends BaseAdapter {

    private List<Character> characters;
    private final Context context;

    public ListaCharactersAdapter(Context context, List<Character> characters) {
        this.context = context;
        this.characters = characters;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Character getItem(int position) {
        return characters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View inflate = createViewInflater(viewGroup);
        TextView characterName = inflate.findViewById(R.id.character_name);
        TextView characterDescription = inflate.findViewById(R.id.character_description);
        characterName.setText(characters.get(position).getName());
        characterDescription.setText(characters.get(position).getDescription());
        return inflate;
    }

    private View createViewInflater(ViewGroup viewGroup){
        return LayoutInflater.from(context).inflate(R.layout.item_character, viewGroup, false);
    }
}
