import {Document} from "../../core/document.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {Admission} from "../admissions/admission.interface";
import {Student} from "../../identity/student.interface";
export interface AdmissionApplication extends Document {
    student: Student;
    academicSession: AcademicSession;
}
