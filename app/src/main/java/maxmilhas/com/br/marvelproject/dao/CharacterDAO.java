package maxmilhas.com.br.marvelproject.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import maxmilhas.com.br.marvelproject.model.Character;

public class CharacterDAO extends Character {

    private final static List<Character> characters = new ArrayList<>();

    public List<Character> todos(){
        return characters;
    }

    public void insere(Character character){
        CharacterDAO.characters.addAll(Arrays.asList(character));
    }
}
