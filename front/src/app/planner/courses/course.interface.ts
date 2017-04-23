import {Faculty} from "../faculties/faculty.interface";
import {MetaObject} from "../../core/meta-object.interface";
export interface Course extends MetaObject{
  code: string;
  title:string;
  titleMs:string;
  titleEn:string;
  credit:number;
  faculty?:Faculty; // todo
}
