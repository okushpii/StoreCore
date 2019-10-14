package com.soft.storecore.core.media.service;

import com.soft.storecore.core.media.entity.MediaVariant;

import java.util.Optional;

public interface MediaVariantService {

    Optional<MediaVariant> find(String mediaGroup, String format);
}
