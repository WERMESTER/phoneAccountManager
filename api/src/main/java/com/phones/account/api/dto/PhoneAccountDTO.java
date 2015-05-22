package com.phones.account.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by nous on 21/05/15.
 */
public class PhoneAccountDTO {

    public String id;
    @NotNull
    @Pattern(regexp="^[+336 | 06]")
    public String msisdn;
    @NotNull
    @Pattern(regexp="[0-9]{20}")
    public String serial;
    @NotNull
    public String firstname;
    @NotNull
    public String lastname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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


}
