import {Document} from "../../core/document.interface";
import {Admission} from "../admissions/admission.interface";
import {Section} from "../sections/section.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {EnrollmentApplicationType} from "./enrollment-application-type.enum";

export interface EnrollmentApplication extends Document {

    description: string;
    sourceNo: string;
    auditNo: string;
    admission: Admission;
    academicSession: AcademicSession;
    enrollmentApplicationType: EnrollmentApplicationType;
}
