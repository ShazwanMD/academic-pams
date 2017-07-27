import { AcademicYear } from './academic-year.interface';
import { AcademicSemester } from './academic-semester-type.enum';
import {MetaObject} from '../../../core/meta-object.interface';

export interface AcademicSession extends MetaObject {
    code: string;
    description: string;
    current: boolean;
    startDate: Date;
    endDate: Date;
    semester: AcademicSemester;
    year: AcademicYear;

}
