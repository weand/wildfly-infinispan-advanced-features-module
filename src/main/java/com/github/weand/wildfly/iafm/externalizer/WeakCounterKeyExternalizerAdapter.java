package com.github.weand.wildfly.iafm.externalizer;

import org.infinispan.counter.impl.weak.WeakCounterKey;

public class WeakCounterKeyExternalizerAdapter extends AbstractExternalizerAdapter<WeakCounterKey> {

    public WeakCounterKeyExternalizerAdapter() {
        super(WeakCounterKey.EXTERNALIZER);
    }

}
