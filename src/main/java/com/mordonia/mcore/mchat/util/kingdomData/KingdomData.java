package com.mordonia.mcore.mchat.util.kingdomData;

public class KingdomData {

    private String name, color;

    public KingdomData(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}


}
