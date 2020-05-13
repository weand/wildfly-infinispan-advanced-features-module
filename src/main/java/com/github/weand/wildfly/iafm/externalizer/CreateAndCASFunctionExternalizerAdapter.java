package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.function.CreateAndCASFunction;

public class CreateAndCASFunctionExternalizerAdapter extends AbstractExternalizerAdapter<CreateAndCASFunction> {

    public CreateAndCASFunctionExternalizerAdapter() {
        super(CreateAndCASFunction.EXTERNALIZER);
    }

}
