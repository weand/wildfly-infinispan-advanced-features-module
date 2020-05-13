package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.ReadFunction;

public class ReadFunctionExternalizerAdapter extends AbstractExternalizerAdapter<ReadFunction> {

    public ReadFunctionExternalizerAdapter() {
        super(ReadFunction.EXTERNALIZER);
    }

}
