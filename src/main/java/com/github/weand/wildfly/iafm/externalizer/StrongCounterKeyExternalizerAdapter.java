package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.strong.StrongCounterKey;

public class StrongCounterKeyExternalizerAdapter extends AbstractExternalizerAdapter<StrongCounterKey> {

    public StrongCounterKeyExternalizerAdapter() {
        super(StrongCounterKey.EXTERNALIZER);
    }

}
