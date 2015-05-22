package com.phones.account.domain;

/**
 * Created by nous on 21/05/15.
 */
public class Owner {

    private final String firstname;
    private final String lastname;

    public Owner(String firstname, String lastname){
        this.firstname =firstname;
        this.lastname =lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
