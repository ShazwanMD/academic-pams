import {MetaObject} from "../core/meta-object.interface";
export interface Guardian extends MetaObject{
  name:string;
  identityNo:string;
  guardianType:GuardianType;
}
