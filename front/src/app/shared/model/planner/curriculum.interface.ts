import {Program} from './program.interface';
import {MetaObject} from '../../../core/meta-object.interface';
import {AcademicSession} from './academic-session.interface';

export interface Curriculum extends MetaObject {
  code: string;
  description: string;
  coreCredit: number;
  curriculumCredit: number;
  electiveCredit: number;
  generalCredit: number;
  languageCredit: number;
  otherCredit: number;
  requiredCredit: number;
  totalCredit: number;
  period: number;
  maxPeriod: number;
  ordinal: number;
  program: Program;
  academicSession: AcademicSession;
}
