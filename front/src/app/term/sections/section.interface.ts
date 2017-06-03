import {MetaObject} from "../../core/meta-object.interface";
import {Offering} from "../offerings/offering.interface";
export interface Section extends MetaObject {
  code: string;
  canonicalCode: string;
  capacity: number;
  ordinal: number;
  offering: Offering;

  // transient
  enrollmentCount?: number;
  appointmentCount?: number;
  selected: boolean;
}
