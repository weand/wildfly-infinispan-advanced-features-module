package com.github.weand.wildfly.iafm.test;

import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class InfinispanAdvancedFeaturesIT {

    @Deployment(name = "test")
    public static WebArchive createBasicDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addAsLibraries(Maven.configureResolver().workOffline(false).loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies().resolve().withTransitivity().asFile())
            .addPackages(true, "com.github.weand.wildfly.iafm.test")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @OperateOnDeployment("test")
    @InSequence(1)
    @Test
    public void testFoo() {
        assertTrue(true);
    }

}
