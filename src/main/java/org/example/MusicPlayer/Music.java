package org.example.MusicPlayer;

public class Music {
    private String name;
    private String patch;

    public Music(String name, String patch) {
        this.name = name;
        this.patch = patch;
    }

    public String getName(){
        return name;
    }

    public String getPatch(){
        return patch;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPatch(String patch){
        this.patch = patch;
    }

}
