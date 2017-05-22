import {Program} from "../programs/program.interface";
import {MetaObject} from "../../core/meta-object.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
export interface Cohort extends MetaObject {
    id: number;
    code: string;
    description: string;
    //program?: Program;
    program: Program;
    academicSession: AcademicSession;
}
