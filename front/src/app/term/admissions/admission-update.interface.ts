import { Document } from "../../core/document.interface";
// import { AdmissionStatus } from "./admission-status.enum";
// import { AcademicStanding } from "./academic-standing.enum";

export interface AdmissionUpdate extends Document {

  id: number;
  gpa: string;
  cgpa: string;
  creditTaken: string;
  creditEarned: string;
  // standing: AcademicStanding,
  // status: AdmissionStatus,

}
