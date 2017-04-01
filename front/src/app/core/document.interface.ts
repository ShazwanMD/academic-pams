import {FlowObject} from "./flow-object.interface";
export interface Document extends FlowObject{

  referenceNo:string;
  sourceNo:string;
  description:string;

}
