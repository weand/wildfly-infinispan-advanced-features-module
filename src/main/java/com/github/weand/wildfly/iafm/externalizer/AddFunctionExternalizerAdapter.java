package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.AddFunction;

public class AddFunctionExternalizerAdapter extends AbstractExternalizerAdapter<AddFunction> {

    public AddFunctionExternalizerAdapter() {
        super(AddFunction.EXTERNALIZER);
    }

}
