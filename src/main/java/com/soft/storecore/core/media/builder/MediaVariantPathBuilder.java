package com.soft.storecore.core.media.builder;

import com.soft.storecore.core.media.entity.MediaVariant;

import java.util.Optional;

public interface MediaVariantPathBuilder {

    Optional<String> buildPath(MediaVariant mediaVariant);
}
