package com.squad7.desafiolocadorasolutis.service.impl;

import com.squad7.desafiolocadorasolutis.exception.PersonException;
import com.squad7.desafiolocadorasolutis.repository.DriverRepository;
import com.squad7.desafiolocadorasolutis.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService{

    private final DriverRepository driverRepository;

    private void ensureEmailAlreadyRegistered(String email) {
       driverRepository.findByEmail(email).ifPresent(driver -> {
        throw new PersonException("Driver already registered with email: " + email);
       });
    }
}