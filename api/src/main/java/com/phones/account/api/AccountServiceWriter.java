package com.phones.account.api;

import com.phones.account.api.dto.PhoneAccountDTO;

/**
 * Created by nous on 21/05/15.
 */
public interface AccountServiceWriter {

    PhoneAccountDTO create(PhoneAccountDTO dto);
    PhoneAccountDTO update(PhoneAccountDTO dto);
    PhoneAccountDTO delete(String id);
}
