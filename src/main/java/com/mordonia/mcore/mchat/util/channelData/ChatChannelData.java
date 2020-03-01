package com.mordonia.mcore.mchat.util.channelData;

public class ChatChannelData {

    private String prefix, name, color, permission;
    private Integer radius;

    public ChatChannelData(String prefix, String name, String color, Integer radius, String permission){
        this.prefix = prefix;
        this.name = name;
        this.color = color;
        this.radius = radius;
        this.permission = permission;

    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
