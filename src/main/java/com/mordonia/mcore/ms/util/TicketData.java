package com.mordonia.mcore.ms.util;

import org.bukkit.entity.Player;

import java.util.UUID;

public class TicketData {
    private String issue, status;
    private Integer id;
    private UUID player, staff;
    private String name;


    public TicketData(Integer id, UUID player, String issue, String status, UUID staff, String name){
        this.id = id;
        this.player = player;
        this.issue = issue;
        this.status = status;
        this.staff = staff;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getPlayer() {
        return player;
    }

    public void setPlayer(UUID player) {
        this.player = player;
    }

    public UUID getStaff() {
        return staff;
    }

    public void setStaff(UUID staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
