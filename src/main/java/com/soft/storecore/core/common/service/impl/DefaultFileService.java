package com.soft.storecore.core.common.service.impl;

import com.soft.storecore.core.common.service.FileService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class DefaultFileService implements FileService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultFileService.class);

    @Override
    public byte[] loadFile(String path) {
        return readFileToByteArray(path);
    }

    protected byte[] readFileToByteArray(String path){
        try {
            return FileUtils.readFileToByteArray(new File(path));
        } catch (IOException e) {
            LOG.error("File is not found by path: {}", path, e);
        }
        return null;
    }
}
