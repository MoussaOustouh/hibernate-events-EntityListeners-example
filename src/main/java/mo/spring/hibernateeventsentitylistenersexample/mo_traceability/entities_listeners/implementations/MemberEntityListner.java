package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.entities_listeners.implementations;

import mo.spring.hibernateeventsentitylistenersexample.entities.Member;
import mo.spring.hibernateeventsentitylistenersexample.mo_traceability.dto.MemberDTO;
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

public class MemberEntityListner implements IEntityListener {

    @Autowired
    private IFilesFraceabilityService filesFraceabilityService;

    public MemberEntityListner() {
    }

    @Override
    @PrePersist
    public void prePersist(Object entity) {
        System.out.println("\n------Member PreInsert Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostPersist
    public void postPersist(Object entity) {
        System.out.println("\n------Member PostInsert Callback------");
        System.out.println(entity.toString());

        MemberDTO memberDTO = Mapper.memberToMemberDTO((Member) entity);
        memberDTO.setUserId(36L);
        memberDTO.setAction("CREATE");
        memberDTO.setIp(FakeData.randomIp());

        filesFraceabilityService.write(Paths.get("traceability/members-traceability.txt"),memberDTO.toString()+"\n");
    }

    @Override
    @PreUpdate
    public void preUpdate(Object entity) {
        System.out.println("\n------Member PreUpdate Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostUpdate
    public void postUpdate(Object entity) {
        System.out.println("\n------Member PostUpdate Callback------");
        System.out.println(entity.toString());

        MemberDTO memberDTO = Mapper.memberToMemberDTO((Member) entity);
        memberDTO.setUserId(36L);
        memberDTO.setAction("UPDATE");
        memberDTO.setIp(FakeData.randomIp());

        filesFraceabilityService.write(Paths.get("traceability/members-traceability.txt"),memberDTO.toString()+"\n");
    }

    @Override
    @PreRemove
    public void preRemove(Object entity) {
        System.out.println("\n------Member PreRemove Callback------");
        System.out.println(entity.toString());
    }

    @Override
    @PostRemove
    public void postRemove(Object entity) {
        System.out.println("\n------Member PostRemove Callback------");
        System.out.println(entity.toString());

        MemberDTO memberDTO = Mapper.memberToMemberDTO((Member) entity);
        memberDTO.setUserId(36L);
        memberDTO.setAction("DELETE");
        memberDTO.setIp(FakeData.randomIp());

        filesFraceabilityService.write(Paths.get("traceability/members-traceability.txt"),memberDTO.toString()+"\n");
    }

    @Override
    @PostLoad
    public void postLoad(Object entity) {
        System.out.println("\n------Member PostLoad Callback------");
        System.out.println(entity.toString());
    }
}
