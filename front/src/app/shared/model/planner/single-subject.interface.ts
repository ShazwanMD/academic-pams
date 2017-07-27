import {Subject} from './subject.interface';
import {Course} from './course.interface';
export interface SingleSubject extends Subject {
  course: Course;
}
