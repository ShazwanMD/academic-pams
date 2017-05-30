import {Faculty} from "../faculties/faculty.interface";
import {MetaObject} from "../../core/meta-object.interface";
import {CourseStatus} from "./course-status.enum";
export interface Course extends MetaObject{
  code: string;
  titleMs:string;
  titleEn:string;
  credit:number;
  status: CourseStatus;
  faculty?:Faculty;
}
