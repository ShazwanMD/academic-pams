import {Document} from "../../core/document.interface";
import {Course} from "../../planner/courses/course.interface";
import {Program} from "../../planner/programs/program.interface";

export interface OfferingApplication extends Document {
  course: Course;
  program: Program;
 
}
