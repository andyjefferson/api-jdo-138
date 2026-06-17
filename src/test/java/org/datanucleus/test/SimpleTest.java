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
        JDOPersistenceManagerFactory pmf = (JDOPersistenceManagerFactory)JDOHelper.getPersistenceManagerFactory("MyTest");

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
