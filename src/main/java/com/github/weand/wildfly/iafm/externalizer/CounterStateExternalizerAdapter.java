package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.api.CounterState;

public class CounterStateExternalizerAdapter extends AbstractExternalizerAdapter<CounterState> {

    public CounterStateExternalizerAdapter() {
        super(CounterState.EXTERNALIZER);
    }

}
