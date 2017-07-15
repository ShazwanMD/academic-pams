import {Actor} from "./actor.interface";
import { Faculty } from "../../planner/faculties/faculty.interface";
import { Program } from "../../planner/programs/program.interface";
export interface Staff extends Actor {
    id: number;
    staffType: number;
    faculty: Faculty;
    program:Program;
    studentStatus:number;

    selected: boolean;

    
}
