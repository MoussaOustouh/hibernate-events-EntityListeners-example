package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.implementations;

import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.IEntityListener;

import javax.persistence.PrePersist;


public class MemberEntityListner implements IEntityListener {

    public MemberEntityListner() {
    }

    @Override
    @PrePersist
    public void prePersist(Object entity) {
        System.out.println(entity.toString());
    }

    @Override
    public void preUpdate(Object entity) {

    }

    @Override
    public void preRemove(Object entity) {

    }

    @Override
    public void postLoad(Object entity) {

    }

    @Override
    public void postRemove(Object entity) {

    }

    @Override
    public void postUpdate(Object entity) {

    }

    @Override
    public void postPersist(Object entity) {

    }
}
