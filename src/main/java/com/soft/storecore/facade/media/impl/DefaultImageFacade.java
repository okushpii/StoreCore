package com.soft.storecore.facade.media.impl;

import com.soft.storecore.core.media.service.ImageService;
import com.soft.storecore.core.media.service.MediaVariantService;
import com.soft.storecore.facade.media.ImageFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultImageFacade implements ImageFacade {

    @Resource
    private MediaVariantService mediaVariantService;
    @Resource
    private ImageService imageService;

    @Override
    public byte[] findImage(String mediaGroup, String format) {
        return mediaVariantService.find(mediaGroup, format)
                .map(mv -> imageService.getImage(mv)).orElse(null);
    }
}
