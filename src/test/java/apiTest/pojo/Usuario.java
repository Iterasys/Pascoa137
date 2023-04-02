package apiTest.pojo;

import java.util.List;

public class Usuario { //POJO - Plain Old Java Object
    private String userId;
    private String password;
    private String userName;
    private List<Isbn> collectionOfIsbns;

    public String getUserId() {
        return userId;
    }

    public List<Isbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
