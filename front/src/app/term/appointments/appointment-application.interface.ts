import {Document} from "../../core/document.interface";
//import {Course} from "../../planner/courses/course.interface";
//import {Program} from "../../planner/programs/program.interface";
import { Section } from "../sections/section.interface";
export interface AppointmentApplication extends Document {

    id: null,
    status: string,
    section: Section;
    //staff: Staff;

}
