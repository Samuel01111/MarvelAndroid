package maxmilhas.com.br.marvelproject.model.api.entity;

import maxmilhas.com.br.marvelproject.extentions.StringUtils;

public class AccessApiKeys {

    private static final String API_KEY = "f99c98405b870c267c9c28669074bfd9";
    private static final String PRIVATE_KEY = "e43fbb0823972c2974ede2804dbcb1944a67c0e5";
    private static final String TS = "1632441614";

    public AccessApiKeys() {
    }

    public String getApiKey() {
        return API_KEY;
    }

    public String getPrivateKey() {
        return PRIVATE_KEY;
    }

    public String getTs(){
        return TS;
    }
    public String getHash(){
        StringUtils stringUtils = new StringUtils();
        String hashUtil = (getTs() + getPrivateKey() + getApiKey());
        return stringUtils.md5(hashUtil);
    }
}
