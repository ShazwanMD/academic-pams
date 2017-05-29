import {Student} from "../../identity/student.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {MetaObject} from "../../core/meta-object.interface";
import {AdmissionStanding} from "./admission-standing.enum";
import {AdmissionStatus} from "./admission-status.enum";

export interface Admission extends MetaObject {
  id: number;
  creditTaken: number;
  creditEearned: number;
  gpa: number;
  cgpa: number;
  ordinal: number;
  student: Student;
  session: AcademicSession;
  standing: AdmissionStanding;
  status: AdmissionStatus;
}
