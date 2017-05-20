import {Document} from "../../core/document.interface";
import {AdmissionStanding} from "./admission-standing.enum";

export interface AdmissionUpdate extends Document {

id: number;
gpa: string;
cgpa: string;
creditTaken: string;
creditEarned: string;
standing: AdmissionStanding;
// status: AdmissionStatus;

  }
