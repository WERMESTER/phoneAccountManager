package com.phones.account.api;


import com.phones.account.api.dto.PhoneAccountDTO;

import java.util.Set;

/**
 * Created by nous on 21/05/15.
 */
public interface AccountServiceReader {

    PhoneAccountDTO fetchPhoneAccount(String uuid);
    Set<PhoneAccountDTO> fetchAllPhoneAccount();
}
