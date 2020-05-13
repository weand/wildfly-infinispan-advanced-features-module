package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.listener.CounterKeyFilter;

public class CounterKeyFilterExternalizerAdapter extends AbstractExternalizerAdapter<CounterKeyFilter> {

    public CounterKeyFilterExternalizerAdapter() {
        super(CounterKeyFilter.EXTERNALIZER);
    }

}
