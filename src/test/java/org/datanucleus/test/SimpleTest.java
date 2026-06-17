package org.datanucleus.test;

import java.util.*;
import org.junit.*;
import javax.jdo.*;
import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;

import static org.junit.Assert.*;
import mydomain.model.*;
import org.datanucleus.util.NucleusLogger;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
        NucleusLogger.GENERAL.info(">> test START");
        Properties props = new Properties();
        props.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        props.setProperty("javax.jdo.option.ConnectionURL", "jdbc:h2:mem:nucleus");
        props.setProperty("javax.jdo.option.ConnectionUserName", "sa");
        props.setProperty("javax.jdo.option.ConnectionPassword", "");
        props.setProperty("datanucleus.allowListenerUpdateAfterInit", "true");
        JDOPersistenceManagerFactory pmf = (JDOPersistenceManagerFactory)JDOHelper.getPersistenceManagerFactory(props);

        try
        {
            NucleusLogger.GENERAL.info(">> adding instance lifecycle listener");
            TrackingLifecycleListener lifecycleTracker = new TrackingLifecycleListener();
            pmf.addInstanceLifecycleListener(lifecycleTracker, null);
            NucleusLogger.GENERAL.info(">> added instance lifecycle listener");
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception in test", thr);
            fail("Failed test : " + thr.getMessage());
        }
        finally 
        {
        }

        pmf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
}
