import {Course} from '../courses/course.interface';
import {MetaObject} from "../../core/meta-object.interface";
export interface Subject extends MetaObject{
  id: null;
  course: Course;
// bundle : BundleSubject;

  // transient

  selected: boolean;
}
