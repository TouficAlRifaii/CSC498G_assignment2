package com.lau.geeklove;

public class Language {
    private String name;
    private String src;

    public Language(String name){
        this.name = name;
        this.src = name.toLowerCase().replaceAll(" " , "") +".jpg";
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getSrc(){
        return src;
    }
    public void setSrc(String src){
        this.src = src;
    }
}
