import {Actor} from './actor.interface';
import {Cohort} from '../planner/cohort.interface';
import {StudyMode} from '../common/study-mode.interface';
export interface Student extends Actor {
  studyMode: StudyMode;
  cohort: Cohort;
  studentStatus: number;
  studentStatusDescription: string;
}
