package com.soft.storecore.core.media.service.impl;

import com.soft.storecore.core.media.dao.MediaVariantDao;
import com.soft.storecore.core.media.entity.MediaVariant;
import com.soft.storecore.core.media.service.MediaVariantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DefaultMediaVariantService implements MediaVariantService {

    @Resource
    private MediaVariantDao mediaVariantDao;

    @Override
    public Optional<MediaVariant> find(String mediaGroup, String format) {
        return mediaVariantDao.find(mediaGroup, format);
    }
}
