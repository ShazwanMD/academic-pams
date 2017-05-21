import { AcademicYear } from './academic-year.interface';
import { AcademicSemester } from './semester-type.enum';
import {MetaObject} from "../../core/meta-object.interface";

export interface AcademicSession extends MetaObject {
    code: string;
    description: string;
    current: boolean;
    startDate: Date;
    endDate: Date;
    academicSemester: AcademicSemester;
    academicYear: AcademicYear;

}
