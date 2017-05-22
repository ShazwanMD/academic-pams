import {Program} from './program.interface';
import {Faculty} from './../faculties/faculty.interface';
import {MetaObject} from "../../core/meta-object.interface";
import {ProgramStatus} from "./program-status.enum";
export interface Program extends MetaObject {
  code: string;
  titleMs: string;
  titleEn: string;
  status: ProgramStatus;
  faculty: Faculty;
}
