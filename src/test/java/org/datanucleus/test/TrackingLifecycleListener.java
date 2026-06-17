package org.datanucleus.test;

import javax.jdo.*;
import javax.jdo.listener.*;
import org.datanucleus.enhancement.Persistable;
import org.datanucleus.util.NucleusLogger;

public class TrackingLifecycleListener implements CreateLifecycleListener,
    DeleteLifecycleListener, LoadLifecycleListener, StoreLifecycleListener
{
    public void postCreate(InstanceLifecycleEvent event)
    {
        NucleusLogger.GENERAL.info("Lifecycle : create for " +
            ((Persistable)event.getSource()).dnGetObjectId());
    }

    public void preDelete(InstanceLifecycleEvent event)
    {
        NucleusLogger.GENERAL.info("Lifecycle : preDelete for " +
            ((Persistable)event.getSource()).dnGetObjectId());
    }

    public void postDelete(InstanceLifecycleEvent event)
    {
        NucleusLogger.GENERAL.info("Lifecycle : postDelete for " +
            ((Persistable)event.getSource()).dnGetObjectId());
    }

    public void postLoad(InstanceLifecycleEvent event)
    {
        NucleusLogger.GENERAL.info("Lifecycle : load for " +
            ((Persistable)event.getSource()).dnGetObjectId());
    }

    public void preStore(InstanceLifecycleEvent event)
    {
        NucleusLogger.GENERAL.info("Lifecycle : preStore for " +
            ((Persistable)event.getSource()).dnGetObjectId());
    }

    public void postStore(InstanceLifecycleEvent event)
    {
        NucleusLogger.GENERAL.info("Lifecycle : postStore for " +
            ((Persistable)event.getSource()).dnGetObjectId());
    }
}
