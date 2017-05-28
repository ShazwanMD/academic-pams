import {StudyMode} from "../common/study-modes/study-mode.interface";
import {AcademicSession} from "../planner/academic-sessions/academic-session.interface";
import {Cohort} from "../planner/cohorts/cohort.interface";
export  interface  TransferCohort {
  from: Cohort;
  to: Cohort;
  academicSession: AcademicSession;
}
