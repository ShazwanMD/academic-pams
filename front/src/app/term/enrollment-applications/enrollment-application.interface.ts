import {Document} from "../../core/document.interface";
import {Admission} from "../admissions/admission.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
export interface EnrollmentApplication extends Document {
  admission: Admission;
  academicSession: AcademicSession;
}
