package maxmilhas.com.br.marvelproject.model.api.entity;

public class Response {
    private Integer code;
    private String etag;
    private Data data;

    public Response(Integer code, String etag, Data data) {
        this.code = code;
        this.etag = etag;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
