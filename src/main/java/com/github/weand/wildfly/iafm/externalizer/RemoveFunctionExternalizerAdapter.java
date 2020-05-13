package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.RemoveFunction;

public class RemoveFunctionExternalizerAdapter extends AbstractExternalizerAdapter<RemoveFunction> {

    public RemoveFunctionExternalizerAdapter() {
        super(RemoveFunction.EXTERNALIZER);
    }

}
