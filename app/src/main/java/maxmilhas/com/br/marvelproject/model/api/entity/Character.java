package maxmilhas.com.br.marvelproject.model.api.entity;

public class Character {

    private Integer id;
    private String name;
    private String description;
    private Thumbnail thumbnail;

    public Character() {}

    public Character(Integer id, String name, Thumbnail thumbnail, String description) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Thumbnail getThumbnail() { return thumbnail; }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
