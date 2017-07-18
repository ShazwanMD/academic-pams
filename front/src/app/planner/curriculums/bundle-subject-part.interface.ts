import {Course} from '../courses/course.interface';
import {MetaObject} from '../../core/meta-object.interface';
export interface BundleSubjectPart extends MetaObject {
  course: Course;
}
