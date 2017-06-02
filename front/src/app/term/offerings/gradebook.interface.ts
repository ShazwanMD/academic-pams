import {MetaObject} from "../../core/meta-object.interface";
import {Assessment} from "../assessments/assessment.interface";
export interface Gradebook extends MetaObject{

  score:number;
  assessment:Assessment;

}
