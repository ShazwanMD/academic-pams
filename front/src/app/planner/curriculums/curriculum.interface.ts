import {Program} from '../programs/program.interface';
import {MetaObject} from '../../core/meta-object.interface';
import {AcademicSession} from '../../planner/academic-sessions/academic-session.interface';

export interface Curriculum extends MetaObject {
  code: string;
  description: string;
  program: Program;
  academicSession: AcademicSession;
}
