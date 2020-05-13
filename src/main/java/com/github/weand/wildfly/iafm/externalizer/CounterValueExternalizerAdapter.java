package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.entries.CounterValue;

public class CounterValueExternalizerAdapter extends AbstractExternalizerAdapter<CounterValue> {

    public CounterValueExternalizerAdapter() {
        super(CounterValue.EXTERNALIZER);
    }

}
