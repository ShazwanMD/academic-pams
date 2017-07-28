import {Document} from '../../../core/document.interface';
import {Admission} from './admission.interface';
import {AcademicSession} from '../planner/academic-session.interface';
import {EnrollmentApplicationType} from './enrollment-application-type.enum';

export interface EnrollmentApplication extends Document {
  auditNo: string;
  sourceNo: string;
  description: string;
  admission: Admission;
  academicSession: AcademicSession;
  applicationType: EnrollmentApplicationType;

  selected: boolean;
}
