package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.InitializeCounterFunction;

public class InitializeCounterFunctionExternalizerAdapter extends AbstractExternalizerAdapter<InitializeCounterFunction> {

    public InitializeCounterFunctionExternalizerAdapter() {
        super(InitializeCounterFunction.EXTERNALIZER);
    }

}
