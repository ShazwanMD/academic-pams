import {MetaObject} from "../../core/meta-object.interface";
export interface Program extends MetaObject{
  code: string;
  title:string;
  titleMs:string;
  titleEn:string;
}
