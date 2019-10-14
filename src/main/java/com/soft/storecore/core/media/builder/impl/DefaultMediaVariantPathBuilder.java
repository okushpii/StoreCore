package com.soft.storecore.core.media.builder.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import com.soft.storecore.core.media.builder.MediaVariantPathBuilder;
import com.soft.storecore.core.media.entity.MediaVariant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class DefaultMediaVariantPathBuilder implements MediaVariantPathBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultMediaVariantPathBuilder.class);

    private static final String SYSTEM_PATH_MEDIA_KEY = "system.path.media";
    private static final String SEPARATOR = "/";

    @Resource
    private ConfigurationService configurationService;

    @Override
    public Optional<String> buildPath(MediaVariant mediaVariant) {
        return getMediaBasePath().flatMap(p -> buildPath(p, mediaVariant));
    }

    private Optional<String> getMediaBasePath() {
        Optional<String> basePath = configurationService.findConfiguration(SYSTEM_PATH_MEDIA_KEY);
        if (basePath.isEmpty()) {
            LOG.error("System media path is not found");
            return Optional.empty();
        }
        return basePath;
    }

    private Optional<String> buildPath(String mediaPath, MediaVariant mediaVariant) {
        String path = mediaPath + SEPARATOR +
                mediaVariant.getFolderName() +
                SEPARATOR +
                mediaVariant.getFileName();

        return Optional.of(path);
    }
}
