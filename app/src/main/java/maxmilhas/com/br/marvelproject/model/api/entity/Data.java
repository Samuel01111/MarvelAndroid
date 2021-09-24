package maxmilhas.com.br.marvelproject.model.api.entity;

import java.util.List;

public class Data {

    private Results results;

    public Data(Results results) {
        this.results = results;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
