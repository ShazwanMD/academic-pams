import {Section} from "../sections/section.interface";
import {Student} from "../../identity/student.interface";
export interface Enrollment {
  id:number;
  student: Student;
  section: Section;
}
