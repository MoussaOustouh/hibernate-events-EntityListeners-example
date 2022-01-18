package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.implementations;

import mo.spring.hibernateeventsentitylistenersexample.entities.Address;
import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.dto.AddressDTO;
import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.IEntityListener;
import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.fake_data.FakeData;
import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.files.IFilesFraceabilityService;
import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.nio.file.Paths;

public class AddressEntityListner implements IEntityListener {

    @Autowired
    private IFilesFraceabilityService filesFraceabilityService;

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

        AddressDTO addressDTO = Mapper.addressToAddressDTO((Address) entity);
        addressDTO.setUserId(36L);
        addressDTO.setAction("CREATE");
        addressDTO.setIp(FakeData.randomIp());

        filesFraceabilityService.write(Paths.get("traceability/addresses-traceability.txt"), addressDTO.toString()+"\n");
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

        AddressDTO addressDTO = Mapper.addressToAddressDTO((Address) entity);
        addressDTO.setUserId(36L);
        addressDTO.setAction("UPDATE");
        addressDTO.setIp(FakeData.randomIp());

        filesFraceabilityService.write(Paths.get("traceability/addresses-traceability.txt"), addressDTO.toString()+"\n");
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

        AddressDTO addressDTO = Mapper.addressToAddressDTO((Address) entity);
        addressDTO.setUserId(36L);
        addressDTO.setAction("DELETE");
        addressDTO.setIp(FakeData.randomIp());

        filesFraceabilityService.write(Paths.get("traceability/addresses-traceability.txt"), addressDTO.toString()+"\n");
    }

    @Override
    @PostLoad
    public void postLoad(Object entity) {
        System.out.println("\n------Address PostLoad Callback------");
        System.out.println(entity.toString());
    }
}
