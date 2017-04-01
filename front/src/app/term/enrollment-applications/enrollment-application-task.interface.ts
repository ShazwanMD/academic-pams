import {FlowState} from "../../core/flow-state.enum";
import {Document} from "../../core/document.interface";
import {EnrollmentApplication} from "./enrollment-application.interface";
export interface EnrollmentApplicationTask extends Document{

  taskId:string;
  taskName:string;
  candidate:string;
  assignee:string;

  totalAmount:number;
  application:EnrollmentApplication;

  flowState:FlowState;
}
