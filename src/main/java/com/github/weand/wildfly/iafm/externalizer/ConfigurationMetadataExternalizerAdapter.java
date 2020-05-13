package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.metadata.ConfigurationMetadata;

public class ConfigurationMetadataExternalizerAdapter extends AbstractExternalizerAdapter<ConfigurationMetadata> {

    public ConfigurationMetadataExternalizerAdapter() {
        super(ConfigurationMetadata.EXTERNALIZER);
    }

}
