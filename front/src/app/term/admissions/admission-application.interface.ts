import {Document} from "../../core/document.interface";
//import {AdmissionStatus} from "./admission-status.enum";
//import {AdmissionStanding} from "./admission-standing.enum";

export interface AdmissionApplication extends Document {

    id: number;
    gpa: string;
    cgpa: string;
    creditTaken: string;
    creditEarned: string;
    //standing: AdmissionStanding;
   // status: AdmissionStatus;


}
