import {MetaObject} from "../core/meta-object.interface";
import {GuarantorType} from "./guarantor-type.enum";
export interface Guarantor extends MetaObject{
  name:string;
  identityNo:string;
  guarantorType:GuarantorType;

}
