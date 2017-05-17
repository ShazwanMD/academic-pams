import {MetaObject} from "../../core/meta-object.interface";
export interface Section extends MetaObject{
  id: number;
  code: string;
  canonicalCode: string;
  enrollmentCount:number;
  appointmentCount:number;
}
