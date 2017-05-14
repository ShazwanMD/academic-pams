import { Section } from "../sections/section.interface";
import { Student } from "../../identity/student.interface";
import { AcademicSession } from "../../planner/academic-sessions/academic-session.interface";
import { MetaObject } from "../../core/meta-object.interface";
// import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
export interface Admission extends MetaObject {
  id: number;
  student: Student;
  session: AcademicSession;
}
