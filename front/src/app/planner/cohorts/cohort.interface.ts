import {Program} from "../programs/program.interface";
import {MetaObject} from "../../core/meta-object.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {AcademicClassification} from "./academic-classification.enum";

export interface Cohort extends MetaObject {
    code: string;
    description: string;
    program: Program;
    academicSession: AcademicSession;
    academicClassification: AcademicClassification;
}
