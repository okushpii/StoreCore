package com.soft.storecore.core.media.service;

import com.soft.storecore.core.media.entity.MediaVariant;

public interface ImageService {

    byte[] getImage(MediaVariant mediaVariant);
}
