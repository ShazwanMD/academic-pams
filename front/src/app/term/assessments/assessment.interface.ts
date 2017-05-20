import {Offering} from './../offerings/offering.interface';
import {MetaObject} from "../../core/meta-object.interface";
import {AssessmentType} from "./assessment-type.enum";
import {AssessmentCategory} from "./assessment-category.enum";

export interface Assessment extends MetaObject {
  code: string;
  canonicalCode: string;
  description: string;
  totalScore: number;
  weight: number;
  assessmentType: AssessmentType;
  assessmentCategory: AssessmentCategory;
  offering: Offering;
}
