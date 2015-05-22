package com.phones.account.domain;


import java.util.UUID;

/**
 * Created by nous on 21/05/15.
 */
public class PhoneAccount {
    private final UUID id;
    private String msisdn;
    private String serial;
    private final Owner owner;



    public PhoneAccount(String msisdn, String serial, Owner owner) {
        this.msisdn = msisdn;
        this.serial = serial;
        this.id = UUID.randomUUID();
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public String getSerial() {
        return serial;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object obj) {
        if(!PhoneAccount.class.isInstance(obj)){
            return false;
        }
        return getId().equals(((PhoneAccount) obj).getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
