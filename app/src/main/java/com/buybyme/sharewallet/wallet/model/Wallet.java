package com.buybyme.sharewallet.wallet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Wallet
 */
public class Wallet implements Serializable {

    /**
     * Id
     */
    String id;
    /**
     * Wallet name
     */
    String name;
    /**
     * Money
     */
    float money;
    /**
     * Description
     */
    String description;
    /**
     * People that are sahring the wallet
     */
    int people;
    /**
     * Is current the wallet
    */
    boolean current;
    /**
     * Create user id
     */
    String idCreator;
    /**
     * User List that share the wallet
     */
    List<String> usersIdlist;
    /**
     * Number of messages
     */
    int messages;

    /**
     * Empty constructor
     */
    public Wallet() {
    }

    // GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }

    public List<String> getUsersIdlist() {
        return usersIdlist;
    }

    public void setUsersIdlist(List<String> usersIdlist) {
        this.usersIdlist = usersIdlist;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }
}
