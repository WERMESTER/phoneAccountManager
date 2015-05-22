package com.phones.account.api.impl;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.phones.account.api.AccountServiceReader;
import com.phones.account.api.dto.PhoneAccountDTO;
import com.phones.account.api.impl.exception.NotFoundException;
import com.phones.account.domain.PhoneAccount;

import java.util.Set;
import java.util.UUID;

/**
 * Created by nous on 21/05/15.
 */
public class AccountServiceReaderImpl implements AccountServiceReader {


    @Override
    public PhoneAccountDTO fetchPhoneAccount(String uuid) {
        PhoneAccount toReturn = AccountRepository.get().get(UUID.fromString(uuid));
        if(toReturn==null){
            throw new NotFoundException();
        }
        return AccountRepository.toDto(toReturn);
    }

    @Override
    public Set<PhoneAccountDTO> fetchAllPhoneAccount() {
        return ImmutableSet.copyOf(Collections2.transform(AccountRepository.get().values(), AccountRepository.TO_DTO));
    }


}
