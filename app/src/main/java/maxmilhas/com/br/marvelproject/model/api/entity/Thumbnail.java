package maxmilhas.com.br.marvelproject.model.api.entity;

public class Thumbnail {

    private String path;
    private String extension;

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public String getStandardLarge() {
        return (path + "/" + "standard_large" + "." + extension).replace("http://", "https://");
    }

    public String getLandscapeAmazing() {
        return (path + "/" + "landscape_amazing" + "." + extension).replace("http://", "https://");
    }

}
