import {Section} from "../sections/section.interface";
import {Student} from "../../identity/student.interface";
// import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {Staff} from "../../identity/staff.interface";
import { AcademicSession } from "../../planner/academic-sessions/academic-session.interface";
import { Offering } from "../offerings/offering.interface";
import { Course } from "../../planner/courses/course.interface";
export interface Appointment {
  id: number;
  student: Staff;
  section: Section;
  session: AcademicSession;
  offering: Offering;
  course: Course;
}
