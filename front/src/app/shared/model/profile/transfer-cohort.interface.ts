import {AcademicSession} from '../planner/academic-session.interface';
import {Cohort} from '../planner/cohort.interface';
export  interface  TransferCohort {
  from: Cohort;
  to: Cohort;
  academicSession: AcademicSession;
}
