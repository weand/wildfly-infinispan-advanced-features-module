package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.ResetFunction;

@SuppressWarnings("rawtypes")
public class ResetFunctionExternalizerAdapter extends AbstractExternalizerAdapter<ResetFunction> {

    public ResetFunctionExternalizerAdapter() {
        super(ResetFunction.EXTERNALIZER);
    }
    
}
