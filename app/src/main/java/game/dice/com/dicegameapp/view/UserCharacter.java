package game.dice.com.dicegameapp.view;

public class UserCharacter {
    private String name;
    private String info;
    private int picture;


    public UserCharacter() {

    }

    public UserCharacter(String name, String info, int picture) {
        this.name = name;
        this.info = info;
        this.picture = picture;
    }

    public UserCharacter(String name, String info) {
        this.name = name;
        this.info = info;
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
