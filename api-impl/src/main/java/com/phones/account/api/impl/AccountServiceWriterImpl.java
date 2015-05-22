package com.phones.account.api.impl;

import com.phones.account.api.AccountServiceWriter;
import com.phones.account.api.dto.PhoneAccountDTO;
import com.phones.account.api.impl.exception.NotFoundException;
import com.phones.account.domain.PhoneAccount;

import java.util.UUID;

/**
 * Created by nous on 21/05/15.
 */
public class AccountServiceWriterImpl implements AccountServiceWriter {

    @Override
    public PhoneAccountDTO create(PhoneAccountDTO dto) {
        PhoneAccount toReturn =AccountRepository.toDomain(dto);
        AccountRepository.create(toReturn);
        return AccountRepository.toDto(toReturn);
    }

    @Override
    public PhoneAccountDTO update(PhoneAccountDTO dto) {
        try {
            PhoneAccount existing = AccountRepository.get().get(UUID.fromString(dto.getId()));
            AccountRepository.update(existing);
            return AccountRepository.toDto(AccountRepository.get().get(existing.getId()));
        }catch (IllegalArgumentException ex){
            throw new NotFoundException();
        }
    }

    @Override
    public PhoneAccountDTO delete(String id) {
        PhoneAccount toReturn = AccountRepository.remove(UUID.fromString(id));
        return toReturn==null?null:AccountRepository.toDto(toReturn);
    }
}
