package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.CompareAndSwapFunction;

public class CompareAndSwapFunctionExternalizerAdapter extends AbstractExternalizerAdapter<CompareAndSwapFunction> {

    public CompareAndSwapFunctionExternalizerAdapter() {
        super(CompareAndSwapFunction.EXTERNALIZER);
    }

}
