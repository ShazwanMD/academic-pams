import {Course} from "../../planner/courses/course.interface";
import {Program} from "../../planner/programs/program.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {MetaObject} from "../../core/meta-object.interface";
export interface Offering extends MetaObject{
  code:string;
  canonicalCode:string;
  course: Course;
  program: Program;
  session: AcademicSession;
}
