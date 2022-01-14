package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners;

public interface IEntityListener {
    void prePersist(Object entity);
    void preUpdate(Object entity);
    void preRemove(Object entity);
    void postLoad(Object entity);
    void postRemove(Object entity);
    void postUpdate(Object entity);
    void postPersist(Object entity);
}
