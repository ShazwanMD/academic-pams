import {Course} from './course.interface';
import {MetaObject} from '../../../core/meta-object.interface';
export interface BundleSubjectPart extends MetaObject {
  course: Course;
  selected?: boolean;
}
