import {Section} from "../sections/section.interface";
import {Student} from "../../identity/student.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {Staff} from "../../identity/staff.interface";
export interface Appointment {
  id: number;
  student: Staff;
  section: Section;
}
