package maxmilhas.com.br.marvelproject.model.api.entity;

import java.util.List;

public class Results {

    private List<Character> results;

    public Results(List<Character> results) {
        this.results = results;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}


