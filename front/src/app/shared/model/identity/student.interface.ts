import { BankCode } from './../common/bank-code.interface';
import {Actor} from './actor.interface';
import {Cohort} from '../planner/cohort.interface';
import {StudyMode} from '../common/study-mode.interface';
import { Program } from "../planner/program.interface";
export interface Student extends Actor {
  studyMode: StudyMode;
  cohort: Cohort;
  program: Program;
  studentStatus: number;
  memo: string;
  balance: number;
  outstanding: boolean;
  minAmount: number;
  NoID: string;
  bankAccountNo: string;
  bankCode: BankCode;
}
