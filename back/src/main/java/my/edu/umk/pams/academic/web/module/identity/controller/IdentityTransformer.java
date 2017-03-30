package my.edu.umk.pams.academic.web.module.identity.controller;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.web.module.identity.vo.Actor;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */
@Component("identityTransformer")
public class IdentityTransformer {

    public Staff toStaffVo(AdStaff staff) {
        Staff m = new Staff();
        m.setId(staff.getId());
        m.setIdentityNo(staff.getIdentityNo());
        m.setName(staff.getName());
        m.setEmail(staff.getEmail());
        m.setMobile(staff.getMobile());
        m.setPhone(staff.getPhone());
        m.setFax(staff.getFax());
        return m;
    }


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

    public List<Staff> toStaffVos(List<AdStaff> staffs) {
        List<Staff> vos = staffs.stream()
                .map((staff) -> toStaffVo(staff))
                .collect(toList());
        return vos;
    }


    public List<Student> toStudentVos(List<AdStudent> students) {
        List<Student> vos = students.stream()
                .map((student) -> toStudentVo(student))
                .collect(toList());
        return vos;
    }

    public List<Actor> toActorVos(List<AdActor> actors) {
        List<Actor> vos = actors.stream()
                .map((actor) -> toActorVo(actor))
                .collect(toList());
        return vos;
    }

    public Actor toActorVo(AdActor actor) {
        if (actor instanceof AdStaff)
            return toStaffVo((AdStaff) actor);
        else return null;
    }
}
