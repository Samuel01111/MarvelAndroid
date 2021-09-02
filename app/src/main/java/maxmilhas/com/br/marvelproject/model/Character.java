package maxmilhas.com.br.marvelproject.model;

public class Character {

    private String name;
    private String pictureUrl;
    private String description;

    public Character(){

    }
    public Character(String name, String pictureUrl, String description) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
