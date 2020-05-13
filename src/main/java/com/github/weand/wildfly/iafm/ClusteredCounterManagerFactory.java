package com.github.weand.wildfly.iafm;

import java.util.Arrays;

import org.infinispan.counter.EmbeddedCounterManagerFactory;
import org.infinispan.counter.api.CounterManager;
import org.infinispan.counter.impl.CounterMetadataFileFinder;
import org.infinispan.counter.impl.CounterModuleLifecycle;
import org.infinispan.counter.impl.manager.EmbeddedCounterManager;
import org.infinispan.factories.GlobalComponentRegistry;
import org.infinispan.manager.EmbeddedCacheManager;

public class ClusteredCounterManagerFactory {

    private ClusteredCounterManagerFactory() {
    }

    @SuppressWarnings("deprecation")
    public static EmbeddedCounterManager create(final EmbeddedCacheManager cacheManager) {
        // initializate CounterMetadataFileFinder and CounterModuleLifecycle:
        // thats what org.infinispan.factories.GlobalComponentRegistry.GlobalComponentRegistry 
        // does when in non wildfly environment.
        final GlobalComponentRegistry gcr = cacheManager.getGlobalComponentRegistry();
        gcr.getComponentMetadataRepo().initialize(
            Arrays.asList(new CounterMetadataFileFinder()),
            CounterManager.class.getClassLoader());
        
        new CounterModuleLifecycle().cacheManagerStarting(gcr, cacheManager.getCacheManagerConfiguration());

        // create and start the counter manager
        final EmbeddedCounterManager counterManager = (EmbeddedCounterManager) EmbeddedCounterManagerFactory.asCounterManager(cacheManager);
        counterManager.start();
        
        return counterManager;
    }

}
