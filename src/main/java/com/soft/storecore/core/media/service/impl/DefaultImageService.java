package com.soft.storecore.core.media.service.impl;

import com.soft.storecore.core.common.service.FileService;
import com.soft.storecore.core.media.builder.MediaVariantPathBuilder;
import com.soft.storecore.core.media.entity.MediaVariant;
import com.soft.storecore.core.media.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefaultImageService implements ImageService {

    @Resource
    private MediaVariantPathBuilder mediaVariantPathBuilder;
    @Resource
    private FileService fileService;

    @Override
    public byte[] getImage(MediaVariant mediaVariant) {
       return mediaVariantPathBuilder.buildPath(mediaVariant)
               .map(p -> fileService.loadFile(p)).orElse(null);
    }
}
