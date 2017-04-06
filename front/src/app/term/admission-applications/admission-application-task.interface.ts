import {FlowState} from "../../core/flow-state.enum";
import {Document} from "../../core/document.interface";
import {AdmissionApplication} from "./admission-application.interface";
export interface AdmissionApplicationTask extends Document{

  taskId:string;
  taskName:string;
  candidate:string;
  assignee:string;

  totalAmount:number;
  application:AdmissionApplication;

  flowState:FlowState;
}
