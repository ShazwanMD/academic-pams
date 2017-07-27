import {Course} from "../planner/course.interface";
import {Program} from "../planner/program.interface";
import {AcademicSession} from "../planner/academic-session.interface";
import {MetaObject} from "../../../core/meta-object.interface";

export interface Offering extends MetaObject {
  id: number;
  code: string;
  canonicalCode: string;
  capacity: number;
  titleMs: string;
  titleEn: string;
  course: Course;
  program: Program;
  academicSession: AcademicSession;

  isOfferingExist: boolean;
}
