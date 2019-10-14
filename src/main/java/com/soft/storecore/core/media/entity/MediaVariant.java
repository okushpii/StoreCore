package com.soft.storecore.core.media.entity;

import com.soft.storecore.core.common.entity.BaseEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MediaVariant extends BaseEntity {

    @NaturalId
    @Column(nullable = false, unique = true, updatable = false)
    private String code;

    @Column(nullable = false)
    private String mediaGroup;

    @Column(nullable = false)
    private String format;

    @Column(nullable = false)
    private String folderName;

    @Column(nullable = false)
    private String fileName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMediaGroup() {
        return mediaGroup;
    }

    public void setMediaGroup(String group) {
        this.mediaGroup = group;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
