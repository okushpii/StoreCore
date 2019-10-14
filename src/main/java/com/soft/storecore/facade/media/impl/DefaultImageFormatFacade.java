package com.soft.storecore.facade.media.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import com.soft.storecore.facade.media.ImageFormatFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultImageFormatFacade implements ImageFormatFacade {

    @Resource
    private ConfigurationService configurationService;

    @Override
    public String getFormat(String key, String defaultValue) {
        return configurationService.findConfiguration(key,
                defaultValue);
    }
}
