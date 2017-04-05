import {Program} from "../programs/program.interface";
export interface Cohort {
  id: number;
  code: string;
  description: string;
  program?: Program;
}
