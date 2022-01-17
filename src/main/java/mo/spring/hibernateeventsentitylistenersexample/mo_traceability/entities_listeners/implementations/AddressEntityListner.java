package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.implementations;

import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.IEntityListener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AddressEntityListner implements IEntityListener {
    public AddressEntityListner() {
    }

    @Override
    @PrePersist
    public void prePersist(Object entity) {
        System.out.println("\n------Address PreInsert Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostPersist
    public void postPersist(Object entity) {
        System.out.println("\n------Address PostInsert Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PreUpdate
    public void preUpdate(Object entity) {
        System.out.println("\n------Address PreUpdate Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostUpdate
    public void postUpdate(Object entity) {
        System.out.println("\n------Address PostUpdate Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PreRemove
    public void preRemove(Object entity) {
        System.out.println("\n------Address PreRemove Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostRemove
    public void postRemove(Object entity) {
        System.out.println("\n------Address PostRemove Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostLoad
    public void postLoad(Object entity) {
        System.out.println("\n------Address PostLoad Callback------");
        System.out.println(entity.toString());
    }
}
