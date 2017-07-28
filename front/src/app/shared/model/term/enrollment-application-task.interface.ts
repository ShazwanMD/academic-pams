import {Document} from '../../../core/document.interface';
import {EnrollmentApplication} from './enrollment-application.interface';
export interface EnrollmentApplicationTask extends Document {

  taskId: string;
  taskName: string;
  candidate: string;
  assignee: string;
  application: EnrollmentApplication;
  // denormalize
  matricNo: string;
}
