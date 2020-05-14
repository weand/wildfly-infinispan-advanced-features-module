package com.github.weand.wildfly.iafm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.ExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.infinispan.counter.api.CounterConfiguration;
import org.infinispan.counter.api.CounterType;
import org.infinispan.counter.api.Storage;
import org.infinispan.counter.api.StrongCounter;
import org.infinispan.counter.impl.manager.EmbeddedCounterManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.jboss.arquillian.container.test.api.ContainerController;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.weand.wildfly.iafm.ClusteredCounterManagerFactory;

@RunWith(Arquillian.class)
public class InfinispanAdvancedFeaturesIT {

    @ArquillianResource
    private ContainerController controller;

    private static EmbeddedCounterManager counterManager;

    @Deployment(name = "test")
    @TargetsContainer("server1")
    public static WebArchive createBasicDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackages(true, "com.github.weand.wildfly.iafm.test")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource(new File("src/test/resources/jboss-deployment-structure.xml"))
            .addAsWebInfResource(new File("src/test/resources/web.xml"));
    }

    @Deployment(name = "test2")
    @TargetsContainer("server2")
    public static WebArchive createBasicDeployment2() {
        return createBasicDeployment();
    }

    @Test
    @InSequence(1)
    @RunAsClient
    public void startServer2() {
        controller.start("server2");
    }

    @OperateOnDeployment("test")
    @InSequence(2)
    @Test
    public void testCounterOnServer1(@ArquillianResource InitialContext context) throws InterruptedException, ExecutionException, NamingException {
        EmbeddedCacheManager cacheManager = (EmbeddedCacheManager) context.lookup("jboss/infinispan/container/clustered-counter");
        assertNotNull(cacheManager);

        assertNull(counterManager);
        counterManager = ClusteredCounterManagerFactory.create(cacheManager);
        assertNotNull(counterManager);

        counterManager.defineCounter("c1",
            CounterConfiguration
                .builder(CounterType.UNBOUNDED_STRONG)
                .initialValue(1)
                .storage(Storage.VOLATILE)
                .build());
        assertTrue(counterManager.isDefined("c1"));

        final StrongCounter c1 = counterManager.getStrongCounter("c1");
        assertEquals(1l, c1.getValue().get().longValue());
        c1.addAndGet(1000);

    }

    @OperateOnDeployment("test2")
    @InSequence(3)
    @Test
    public void testCounterOnServer2(@ArquillianResource InitialContext context) throws InterruptedException, ExecutionException, NamingException {

        EmbeddedCacheManager cacheManager = (EmbeddedCacheManager) context.lookup("jboss/infinispan/container/clustered-counter");
        assertNotNull(cacheManager);

        assertNull(counterManager);
        counterManager = ClusteredCounterManagerFactory.create(cacheManager);
        assertNotNull(counterManager);

        assertTrue(counterManager.isDefined("c1"));
        //
        final StrongCounter c1 = counterManager.getStrongCounter("c1");
        assertEquals(1001l, c1.getValue().get().longValue());

    }

    @OperateOnDeployment("test")
    @InSequence(4)
    @Test
    public void testStopCounterOnServer1(@ArquillianResource InitialContext context) throws InterruptedException, ExecutionException, NamingException {
        assertNotNull(counterManager);
        counterManager.stop();
    }

    @OperateOnDeployment("test2")
    @InSequence(5)
    @Test
    public void testStopCounterOnServer2(@ArquillianResource InitialContext context) throws InterruptedException, ExecutionException, NamingException {
        assertNotNull(counterManager);
        counterManager.stop();
    }
}
