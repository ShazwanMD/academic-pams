import { Program } from './program.interface';
import { Faculty } from './../faculties/faculty.interface';
import {MetaObject} from "../../core/meta-object.interface";
export interface Program extends MetaObject{
   faculty: Faculty;
   program: Program;
   
   code: string;
   title:string;
    titleMs:string;
    titleEn:string;
}
