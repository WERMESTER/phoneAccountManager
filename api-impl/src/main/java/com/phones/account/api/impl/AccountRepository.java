package com.phones.account.api.impl;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.phones.account.api.dto.PhoneAccountDTO;
import com.phones.account.domain.Owner;
import com.phones.account.domain.PhoneAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by nous on 21/05/15.
 */
public class AccountRepository {



    private AccountRepository(){
        throw new AssertionError();
    }

    private final static Map<UUID, PhoneAccount> repo;
    static{
        repo = new HashMap<>();
        PhoneAccount pa1 = new PhoneAccount("0663918185", "12345678912345678912", new Owner("user1", "user1"));
        PhoneAccount pa2 = new PhoneAccount("0663918186", "12345678998765432112", new Owner("user2", "user2"));
        repo.put(pa1.getId(), pa1);
        repo.put(pa2.getId(), pa2);
    }


    public static Map<UUID, PhoneAccount> get(){
        return ImmutableMap.copyOf(repo);
    }

    public static void create(PhoneAccount phoneAccount){
        add(phoneAccount, false);
    }

    public static void update(PhoneAccount phoneAccount){
        add(phoneAccount, true);
    }

    private static void add(PhoneAccount phoneAccount, boolean update){
        Preconditions.checkArgument(phoneAccount!=null);
        PhoneAccount existing = repo.get(phoneAccount.getId());
        if(update){
            Preconditions.checkArgument(existing!=null);
            existing.setMsisdn(phoneAccount.getMsisdn());
            existing.setSerial(phoneAccount.getSerial());
        }else{
            Preconditions.checkArgument(existing==null);
            existing = phoneAccount;
        }
        repo.put(phoneAccount.getId(), existing);
    }

    static PhoneAccountDTO toDto(PhoneAccount phoneAccount){
        PhoneAccountDTO toReturn = new PhoneAccountDTO();
        toReturn.setId(phoneAccount.getId().toString());
        toReturn.setMsisdn(phoneAccount.getMsisdn());
        toReturn.setSerial(phoneAccount.getSerial());
        toReturn.setFirstname(phoneAccount.getOwner().getFirstname());
        toReturn.setLastname(phoneAccount.getOwner().getLastname());
        return toReturn;
    }

    static final Function<PhoneAccount, PhoneAccountDTO> TO_DTO = new Function<PhoneAccount, PhoneAccountDTO>() {
        @Override
        public PhoneAccountDTO apply(PhoneAccount input) {
            return toDto(input);
        }
    };


    static PhoneAccount toDomain(PhoneAccountDTO dto) {
        return new PhoneAccount(dto.getMsisdn(), dto.getSerial(), new Owner(dto.getFirstname(), dto.getLastname()));
    }

    public static PhoneAccount remove(UUID uuid) {
        return repo.remove(uuid);
    }
}
