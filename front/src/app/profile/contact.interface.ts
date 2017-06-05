import {MetaObject} from "../core/meta-object.interface";
import {ContactType} from "./contact-type.enum";
export interface Contact extends MetaObject{
  name:string;
  identityNo:string;
  contactType:ContactType;
  phone:string;
}
