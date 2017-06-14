import {Faculty} from "../faculties/faculty.interface";
import {MetaObject} from "../../core/meta-object.interface";
import {CourseStatus} from "./course-status.enum";
import {CourseClassification} from "./course-classification.enum";
export interface Course extends MetaObject{
  code: string;
  titleMs:string;
  titleEn:string;
  credit:number;
  classification ?: CourseClassification;
  status: CourseStatus;
  faculty?:Faculty;
}
