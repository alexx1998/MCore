package com.mordonia.mcore.mchat.util.playerData;

public class PlayerChatData {
    private String firstname, lastname, kingdom, chatcolor, rank1, rank2;
    private boolean global, local, kingdom_chat, market, staff, ticket;
    public PlayerChatData(String firstname, String lastname, String kingdom, String chatcolor, Boolean global, Boolean local, Boolean kingdom_chat, Boolean market, Boolean staff, Boolean ticket, String rank1, String rank2) {
        this.ticket = ticket;
        this.firstname = firstname;
        this.lastname = lastname;
        this.chatcolor = chatcolor;
        this.kingdom = kingdom;
        this.global= global;
        this.local = local;
        this.kingdom_chat = kingdom_chat;
        this.market = market;
        this.staff = staff;
        this.rank1 = rank1;
        this.rank2 = rank2;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getChatcolor() {
        return chatcolor;
    }

    public void setChatcolor(String chatcolor) {
        this.chatcolor = chatcolor;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isKingdom_chat() {
        return kingdom_chat;
    }

    public void setKingdom_chat(boolean kingdom_chat) {
        this.kingdom_chat = kingdom_chat;
    }

    public boolean isMarket() {
        return market;
    }

    public void setMarket(boolean market) {
        this.market = market;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public boolean isTicket() {
        return ticket;
    }

    public void setTicket(boolean ticket) {
        this.ticket = ticket;
    }

    public String getRank1() {
        return rank1;
    }

    public void setRank1(String rank1) {
        this.rank1 = rank1;
    }

    public String getRank2() {
        return rank2;
    }

    public void setRank2(String rank2) {
        this.rank2 = rank2;
    }
}
