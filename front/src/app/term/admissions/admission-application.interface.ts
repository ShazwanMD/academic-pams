import {Document} from '../../core/document.interface';

export interface AdmissionApplication extends Document {
    gpa: string;
    cgpa: string;
    creditTaken: string;
    creditEarned: string;

}
