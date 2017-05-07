import {Course} from "../../planner/courses/course.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {MetaObject} from "../../core/meta-object.interface";
export interface Offering extends MetaObject{
  course: Course;
  session:AcademicSession;
}
