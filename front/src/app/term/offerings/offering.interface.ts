import {Course} from "../../planner/courses/course.interface";
import {Program} from "../../planner/programs/program.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {MetaObject} from "../../core/meta-object.interface";
import {Document} from "../../core/document.interface";

export interface Offering extends MetaObject{
//export interface Offering extends Document {
  code:string;
  canonicalCode:string;
  titleMs:string;
  titleEn:string;
  course: Course;
  program: Program;
  academicSession: AcademicSession;
}
