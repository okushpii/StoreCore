package com.soft.storecore.core.media.dao.impl;

import com.soft.storecore.core.common.dao.util.SessionProvider;
import com.soft.storecore.core.media.dao.MediaVariantDao;
import com.soft.storecore.core.media.entity.MediaVariant;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

@Repository
public class DefaultMediaVariantDao implements MediaVariantDao {

    private static final String FIND_BY_MEDIA_GROUP_AND_FORMAT_QUERY = "SELECT mv FROM MediaVariant mv" +
            " WHERE mv.mediaGroup = :mediaGroup AND mv.format = :format";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public Optional<MediaVariant> find(String mediaGroup, String format) {
        return Optional.ofNullable(sessionProvider.getSession()
                .createQuery(FIND_BY_MEDIA_GROUP_AND_FORMAT_QUERY, MediaVariant.class)
                .setParameter("mediaGroup", mediaGroup).setParameter("format", format)
                .uniqueResult());
    }
}
