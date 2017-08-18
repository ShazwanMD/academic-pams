import {MetaObject} from '../../../core/meta-object.interface';
import {Actor} from '../identity/actor.interface';
import {StudyCenter} from '../../../secure/setup/study-centers/study-center.interface';
import {AcademicSession} from '../planner/academic-session.interface';
import {Program} from '../planner/program.interface';
import {Student} from '../identity/student.interface';

export interface GraduationApplication extends MetaObject {
    referenceNo: string;
sourceNo: string;
description: string;
memo: string;
cgpa: number;
creditHour: number;
student: Student;
academicSession: AcademicSession;
}

