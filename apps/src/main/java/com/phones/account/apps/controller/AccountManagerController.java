package com.phones.account.apps.controller;

import com.google.common.base.Preconditions;
import com.phones.account.api.AccountServiceReader;
import com.phones.account.api.AccountServiceWriter;
import com.phones.account.api.dto.PhoneAccountDTO;
import com.phones.account.api.impl.AccountServiceReaderImpl;
import com.phones.account.api.impl.AccountServiceWriterImpl;
import com.phones.account.api.impl.exception.NotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by nous on 21/05/15.
 */
@Controller
@RequestMapping("services/accounts")
@EnableAutoConfiguration
public class AccountManagerController {
    public static void main(String[] args) {
        SpringApplication.run(AccountManagerController.class);
    }

    private static final AccountServiceReader reader = new AccountServiceReaderImpl();
    private static final AccountServiceWriter writer = new AccountServiceWriterImpl();

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  Collection<PhoneAccountDTO> all(){
        return reader.fetchAllPhoneAccount();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  PhoneAccountDTO account(@PathVariable String id){
        return reader.fetchPhoneAccount(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes="application/json" , produces = "application/json")
    public @ResponseBody  PhoneAccountDTO createAccount(@RequestBody @Valid PhoneAccountDTO dto){
        return writer.create(dto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes="application/json" , produces = "application/json")
    public @ResponseBody  PhoneAccountDTO updateAccount(@PathVariable String id, @RequestBody @Valid PhoneAccountDTO dto){
        Preconditions.checkArgument(id.equals(dto));
        return writer.update(dto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE , produces = "application/json")
    public @ResponseBody  PhoneAccountDTO updateAccount(@PathVariable String id){
        return writer.delete(id);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "resource not found")
    public void trapNotFound(NotFoundException ex){
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad request")
    public void trapNotFoundIllegal(IllegalArgumentException ex){
    }




}
