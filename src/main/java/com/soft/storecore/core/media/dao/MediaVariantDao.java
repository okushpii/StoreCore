package com.soft.storecore.core.media.dao;

import com.soft.storecore.core.media.entity.MediaVariant;

import java.util.Optional;

public interface MediaVariantDao {

    Optional<MediaVariant> find(String mediaGroup, String format);
}
