package com.soft.storecore.core.common.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDGenerationService implements IdGenarationService {

    @Override
    public String generate() {
      return  UUID.randomUUID().toString();
    }
}
