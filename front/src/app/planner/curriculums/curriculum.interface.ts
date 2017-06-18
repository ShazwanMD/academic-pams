import {Program} from '../programs/program.interface';
import {MetaObject} from '../../core/meta-object.interface';
import {AcademicSession} from '../../planner/academic-sessions/academic-session.interface';

export interface Curriculum extends MetaObject {
  id: null;
  code: string;
  description: string;
  core: string,
  curriculum: string,
  elective: string,
  general: string,
  language: string,
  other: string,
  required: string,
  totalCredit: string,
  period: string,
  maxPeriod: string,
  ordinal: string,
  program: Program;
  academicSession: AcademicSession;
}
