import {Program} from './program.interface';
import {Faculty} from './../faculties/faculty.interface';
import {MetaObject} from "../../core/meta-object.interface";
import {ProgramStatus} from "./program-status.enum";
import {ProgramLevel} from "../program-levels/program-level.interface";
export interface Program extends MetaObject {
  code: string;
  titleMs: string;
  titleEn: string;
  status: ProgramStatus;
  faculty: Faculty;
  level :ProgramLevel
}
