import {MetaObject} from "../../core/meta-object.interface";
import {Document} from "../../core/document.interface";

export interface OfferingUpdate extends MetaObject{
//export interface Offering extends Document {
  id: null;
  capacity: number;
  titleMs:string;
  titleEn:string;
 
}
