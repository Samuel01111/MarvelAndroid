package maxmilhas.com.br.marvelproject.model.api.entity;

public class Thumbnail {
    private String path;
    private String extesion;

    public Thumbnail(String path, String extesion) {
        this.path = path;
        this.extesion = extesion;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtesion() {
        return extesion;
    }

    public void setExtesion(String extesion) {
        this.extesion = extesion;
    }
}
