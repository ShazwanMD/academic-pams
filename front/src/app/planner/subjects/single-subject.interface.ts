import {Course} from '../courses/course.interface';
import {MetaObject} from "../../core/meta-object.interface";
export interface Subject extends MetaObject{
  id: null;
  course: Course;


  // transient

  selected: boolean;
}
