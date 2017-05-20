import { Offering } from './../offerings/offering.interface';
import { AcademicSession } from './../../planner/academic-sessions/academic-session.interface';
import { MetaObject } from "../../core/meta-object.interface";
import {AssessmentType} from "./assessment-type.enum";
import {AssessmentCategory} from "./assessment-category.enum";

export interface Assessment extends MetaObject {
    code: string;
    canonicalCode: string;
    description: string;
    ordinal: number;
    assessmentType: AssessmentType;
    session: AcademicSession;
    assessmentCategory: AssessmentCategory;
    offering: Offering;
}
