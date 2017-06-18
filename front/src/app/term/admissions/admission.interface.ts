import { StudyCenter } from './../../setup/study-centers/study-center.interface';
import { Cohort } from './../../planner/cohorts/cohort.interface';
import { Section } from "../sections/section.interface";
import { Student } from "../../identity/student.interface";
import { AcademicSession } from "../../planner/academic-sessions/academic-session.interface";
import { MetaObject } from "../../core/meta-object.interface";
import { AdmissionStatus } from "./admission-status.enum";
import { AcademicStanding } from "./academic-standing.enum";

export interface Admission extends MetaObject {

  id: null;
  gpa: number;
  cgpa: number;
  creditTaken: number;
  creditEarned: number;
  cohort: Cohort;
  student: Student;
  academicSession: AcademicSession;
  standing: AcademicStanding;
  status: AdmissionStatus;
  studyCenter: StudyCenter;

}
