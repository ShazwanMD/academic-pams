import {Section} from "../sections/section.interface";
import {Admission} from "../admissions/admission.interface";
import {Student} from "../../identity/student.interface";
export interface Enrollment {
  id: number;
  student: Student;
  section: Section;
  admission: Admission;
  //status: Status;
}
