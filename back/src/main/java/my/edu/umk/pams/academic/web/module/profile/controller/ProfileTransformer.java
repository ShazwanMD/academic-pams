package my.edu.umk.pams.academic.web.module.profile.controller;

import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.profile.vo.Address;
import my.edu.umk.pams.academic.web.module.profile.vo.Contact;
import my.edu.umk.pams.academic.web.module.profile.vo.Guarantor;
import my.edu.umk.pams.academic.web.module.profile.vo.Guardian;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */
@Component
public class ProfileTransformer {

    public Student toStudentVo(AdStudent student) {
        Student m = new Student();
        m.setId(student.getId());
        m.setIdentityNo(student.getIdentityNo());
        m.setName(student.getName());
        m.setEmail(student.getEmail());
        m.setMobile(student.getMobile());
        m.setPhone(student.getPhone());
        m.setFax(student.getFax());
        return m;
    }

    public Guardian toGuardianVo(AdGuardian guardian) {
        Guardian m = new Guardian();
        m.setId(guardian.getId());
        m.setName(guardian.getName());
        m.setIdentityNo(guardian.getIdentityNo());
//        m.setIdentityNo(guardian.getType().name());
        return m;
    }

    public Guarantor toGuarantorVo(AdGuarantor guarantor) {
        Guarantor m = new Guarantor();
        m.setId(guarantor.getId());
        m.setName(guarantor.getName());
        m.setIdentityNo(guarantor.getIdentityNo());
//        m.setIdentityNo(guarantor.getType().name());
        
        return m;
    }

    public Address toAddressVo(AdAddress address) {
        Address m = new Address();
        m.setId(address.getId());
        m.setAddress1(address.getAddress1());
        m.setAddress2(address.getAddress2());
        m.setAddress3(address.getAddress3());
        m.setPostcode(address.getPostCode());
        return m;
    }

    public Contact toContactVo(AdContact contact) {
        Contact m = new Contact();
        m.setId(contact.getId());
        m.setName(contact.getName());
        m.setIdentityNo(contact.getIdentityNo());
//        m.setType(contact.getType().name());
        return m;
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
