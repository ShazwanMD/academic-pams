import {Program} from './program.interface';
import {MetaObject} from '../../../core/meta-object.interface';
import {AcademicSession} from './academic-session.interface';
import {AcademicClassification} from './academic-classification.enum';
import { Curriculum } from "./curriculum.interface";

export interface Cohort extends MetaObject {
  code: string;
  description: string;
  program: Program;
  academicSession: AcademicSession;
  curriculum: Curriculum;
  academicClassification: AcademicClassification;
}
