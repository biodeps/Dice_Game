package game.dice.com.dicegameapp.view;

public class UserCharacter {
    private String name;
    private String info;
    private int picture;


    public UserCharacter() {

    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getPicture() { return picture; }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPicture(int picture) { this.picture = picture; }

}
