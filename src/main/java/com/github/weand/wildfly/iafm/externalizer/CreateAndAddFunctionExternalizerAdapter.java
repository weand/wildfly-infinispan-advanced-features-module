package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.CreateAndAddFunction;

public class CreateAndAddFunctionExternalizerAdapter extends AbstractExternalizerAdapter<CreateAndAddFunction> {

    public CreateAndAddFunctionExternalizerAdapter() {
        super(CreateAndAddFunction.EXTERNALIZER);
    }

}
