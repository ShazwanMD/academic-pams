
import {GraduationApplication} from "./graduation-application.interface";
import {FlowState} from "../../core/flow-state.enum";
import {Document} from "../../core/document.interface";
import {Student} from "../../identity/student.interface";
export interface GraduationApplicationTask extends Document {
  taskId: string;
  taskName: string;
  candidate: string;
  assignee: string;
  referenceNo: string;
  sourceNo: string;
  description: string;
  cgpa: number;
  creditHour: number;
  student: Student;
  application: GraduationApplication;
  flowState: FlowState;
}
