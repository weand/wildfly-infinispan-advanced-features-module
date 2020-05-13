package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.api.CounterConfiguration;

public class CounterConfigurationExternalizerAdapter extends AbstractExternalizerAdapter<CounterConfiguration> {

    public CounterConfigurationExternalizerAdapter() {
        super(CounterConfiguration.EXTERNALIZER);
    }
    
}
