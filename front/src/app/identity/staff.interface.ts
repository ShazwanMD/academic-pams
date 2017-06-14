import { Program } from './../planner/programs/program.interface';
import { Faculty } from './../planner/faculties/faculty.interface';
import { Actor } from "./actor.interface";
import { StaffType } from "./staff-type.enum";

export interface Staff extends Actor {
    
    id: number;
    staffType: StaffType;
    faculty: Faculty;
    program: Program;


}
