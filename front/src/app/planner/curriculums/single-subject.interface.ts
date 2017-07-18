import {Course} from '../courses/course.interface';
import {Subject} from './subject.interface';
export interface SingleSubject extends Subject {
  course: Course;
}
