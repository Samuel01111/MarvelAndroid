package maxmilhas.com.br.marvelproject.model.api.entity;

import java.util.List;

public class DataDetails {

    private List<Character> results;

    public DataDetails(List<Character> results) {
        this.results = results;
    }

    public List<Character> getResults() {
        return results;
    }

}


