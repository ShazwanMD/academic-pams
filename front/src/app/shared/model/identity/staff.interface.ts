import {Actor} from './actor.interface';
import {Faculty} from '../planner/faculty.interface';
import {Program} from '../planner/program.interface';
export interface Staff extends Actor {
  staffType: number;
  faculty: Faculty;
  program: Program;
  selected: boolean;
  category:String;
  title:String;
}
