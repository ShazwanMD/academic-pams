import {StudyCenter} from '../../../secure/setup/study-centers/study-center.interface';
import {Cohort} from '../planner/cohort.interface';
import {Student} from '../identity/student.interface';
import {AcademicSession} from '../planner/academic-session.interface';
import {MetaObject} from '../../../core/meta-object.interface';
import {AdmissionStatus} from './admission-status.enum';
import {AcademicStanding} from './academic-standing.enum';

export interface Admission extends MetaObject {

  id: null;
  gpa: number;
  cgpa: number;
  creditTaken: number;
  creditEarned: number;
  ordinal: number;
  cohort: Cohort;
  student: Student;
  academicSession: AcademicSession;
  standing: AcademicStanding;
  status: AdmissionStatus;
  studyCenter: StudyCenter;

  //transient
  enrollmentCount?: number;
  enrollmentApplicationCount?: number;



}
