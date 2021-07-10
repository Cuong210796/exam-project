package com.cuong.service;

import com.cuong.model.ConfirmationToken;

public interface ConfirmationTokenService {
    ConfirmationToken findByToken(String token);
    void save(ConfirmationToken confirmationToken);
}
