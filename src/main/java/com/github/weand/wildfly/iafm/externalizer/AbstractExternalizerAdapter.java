package com.github.weand.wildfly.iafm.externalizer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.infinispan.commons.marshall.AdvancedExternalizer;
import org.wildfly.clustering.marshalling.Externalizer;

public abstract class AbstractExternalizerAdapter<T> implements Externalizer<T> {

    private final AdvancedExternalizer<T> externalizer;

    public AbstractExternalizerAdapter(final AdvancedExternalizer<T> externalizer) {
        this.externalizer = externalizer;
    }

    @Override
    public void writeObject(ObjectOutput output, T object) throws IOException {
        externalizer.writeObject(output, object);

    }

    @Override
    public T readObject(ObjectInput input) throws IOException, ClassNotFoundException {
        return externalizer.readObject(input);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetClass() {
        return (Class<T>) externalizer.getTypeClasses().iterator().next();
    }

}
