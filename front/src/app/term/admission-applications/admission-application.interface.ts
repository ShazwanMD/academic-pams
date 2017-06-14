import { Staff } from './../../identity/staff.interface';
import { MetaObject } from './../../core/meta-object.interface';
import { Actor } from './../../identity/actor.interface';
import { StudyCenter } from './../../setup/study-centers/study-center.interface';
import { AcademicSession } from "../../planner/academic-sessions/academic-session.interface";
import { Program } from "../../planner/programs/program.interface";
import { Student } from "../../identity/student.interface";

export interface AdmissionApplication extends MetaObject{
    referenceNo: string;
    sourceNo: string;
    auditNo: string;
    description: string;
    cancelComment: string;
    removeComment: string;
    actor: Actor;
    // staff: Staff;
    student: Student;
    academicSession: AcademicSession;
    program: Program;
    studyCenter: StudyCenter;
}

