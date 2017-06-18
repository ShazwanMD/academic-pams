import {Program} from '../programs/program.interface';
import {MetaObject} from '../../core/meta-object.interface';
import {AcademicSession} from '../../planner/academic-sessions/academic-session.interface';

export interface Curriculum extends MetaObject {
  id: null;
  code: string;
  description: string;
  core: string,
  curriculum: number,
  elective: number,
  general: number,
  language: number,
  other: number,
  required: number,
  totalCredit: number,
  period: number,
  maxPeriod: number,
  ordinal: number,
  program: Program;
  academicSession: AcademicSession;
}
