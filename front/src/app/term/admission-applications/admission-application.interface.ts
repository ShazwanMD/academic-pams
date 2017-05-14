import {Document} from "../../core/document.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {Admission} from "../admissions/admission.interface";
export interface AdmissionApplication extends Document {
    admission: Admission;
    academicSession: AcademicSession;
}
