import {Section} from "../sections/section.interface";
import {Student} from "../../identity/student.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
export interface Enrollment {
  id: number;
  student: Student;
  section: Section;
}
