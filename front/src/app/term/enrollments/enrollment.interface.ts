//import {MetaObject} from "../core/meta-object.interface";
import {Section} from "../sections/section.interface";
import {Admission} from "../admissions/admission.interface";
import {Student} from "../../identity/student.interface";
import {EnrollmentStatus} from "./enrollment-status.enum";
import {EnrollmentStanding} from "./enrollment-standing.enum";

export interface Enrollment {
  id: number;
   status: number;
  student: Student;
  section: Section;
  admission: Admission;
  enrollmentStatus: EnrollmentStatus;
  enrollmentStanding: EnrollmentStanding;  
 
}
