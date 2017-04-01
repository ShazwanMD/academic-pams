import {Faculty} from "../faculties/faculty.interface";
export interface Course{
  id:number;
  code: string;
  title:string;
  titleMs:string;
  titleEn:string;
  credit:number;
  faculty?:Faculty; // todo
}
