package my.edu.umk.pams.academic.web.module.profile.controller;

import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.identity.vo.StudentStatus;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.profile.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */
@Component
public class ProfileTransformer {

    @Autowired
    private CommonTransformer commonTransformer;

    @Autowired
    private PlannerTransformer plannerTransformer;

    public Student toStudentVo(AdStudent e) {
        Student vo = new Student();
        vo.setId(e.getId());
        vo.setIdentityNo(e.getIdentityNo());
        vo.setName(e.getName());
        vo.setEmail(e.getEmail());
        vo.setMobile(e.getMobile());
        vo.setPhone(e.getPhone());
        vo.setFax(e.getFax());
        vo.setStudentStatus(StudentStatus.get(e.getStudentStatus().ordinal()));
        vo.setStudyMode(commonTransformer.toStudyModeVo(e.getStudyMode()));
        vo.setCohort(plannerTransformer.toCohortVo(e.getCohort()));
        return vo;
    }

    public Guardian toGuardianVo(AdGuardian guardian) {
        Guardian vo = new Guardian();
        vo.setId(guardian.getId());
        vo.setName(guardian.getName());
        vo.setIdentityNo(guardian.getIdentityNo());
        vo.setGuardianType(GuardianType.get(guardian.getType().ordinal()));
        return vo;
    }

    public Guarantor toGuarantorVo(AdGuarantor guarantor) {
        Guarantor vo = new Guarantor();
        vo.setId(guarantor.getId());
        vo.setName(guarantor.getName());
        vo.setIdentityNo(guarantor.getIdentityNo());
        vo.setGuarantorType(GuarantorType.get(guarantor.getType().ordinal()));
        return vo;
    }

    public Address toAddressVo(AdAddress address) {
        Address vo = new Address();
        vo.setId(address.getId());
        vo.setAddress1(address.getAddress1());
        vo.setAddress2(address.getAddress2());
        vo.setAddress3(address.getAddress3());
        vo.setPostcode(address.getPostCode());
        vo.setAddressType(AddressType.get(address.getType().ordinal()));
        return vo;
    }

    public Contact toContactVo(AdContact contact) {
        Contact vo = new Contact();
        vo.setId(contact.getId());
        vo.setName(contact.getName());
        vo.setIdentityNo(contact.getIdentityNo());
        vo.setContactType(ContactType.get(contact.getType().ordinal()));
        return vo;
    }

    public List<Student> toStudentVos(List<AdStudent> students) {
        List<Student> vos = students.stream()
                .map((student) -> toStudentVo(student))
                .collect(toList());
        return vos;
    }

    public List<Guardian> toGuardianVos(List<AdGuardian> guardians) {
        List<Guardian> vos = guardians.stream()
                .map((guardian) -> toGuardianVo(guardian))
                .collect(toList());
        return vos;
    }

    public List<Contact> toContactVos(List<AdContact> contacts) {
        List<Contact> vos = contacts.stream()
                .map((contact) -> toContactVo(contact))
                .collect(toList());
        return vos;
    }

    public List<Address> toAddressVos(List<AdAddress> addresss) {
        List<Address> vos = addresss.stream()
                .map((address) -> toAddressVo(address))
                .collect(toList());
        return vos;
    }

    public List<Guarantor> toGuarantorVos(List<AdGuarantor> guarantors) {
        List<Guarantor> vos = guarantors.stream()
                .map((guarantor) -> toGuarantorVo(guarantor))
                .collect(toList());
        return vos;
    }
}
