//import {MetaObject} from "../core/meta-object.interface";
import {Section} from "../sections/section.interface";
import {Admission} from "../admissions/admission.interface";
import {Student} from "../../identity/student.interface";
import {AdmissionStatus} from "./admission-status.enum";
export interface Enrollment {
  id: number;
  student: Student;
  section: Section;
  admission: Admission;
  admissionStatus: AdmissionStatus;
}
