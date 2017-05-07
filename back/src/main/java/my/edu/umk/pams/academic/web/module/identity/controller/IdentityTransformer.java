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
        Staff vo = new Staff();
        vo.setId(staff.getId());
        vo.setIdentityNo(staff.getIdentityNo());
        vo.setName(staff.getName());
        vo.setEmail(staff.getEmail());
        vo.setMobile(staff.getMobile());
        vo.setPhone(staff.getPhone());
        vo.setFax(staff.getFax());
        return vo;
    }


    public Student toStudentVo(AdStudent student) {
        Student vo = new Student();
        vo.setId(student.getId());
        vo.setIdentityNo(student.getIdentityNo());
        vo.setName(student.getName());
        vo.setEmail(student.getEmail());
        vo.setMobile(student.getMobile());
        vo.setPhone(student.getPhone());
        vo.setFax(student.getFax());
        return vo;
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
