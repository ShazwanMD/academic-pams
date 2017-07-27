import {Section} from "./section.interface";
import {EnrollmentApplicationAction} from "./enrollment-application-action.enum";
import {MetaObject} from "../../../core/meta-object.interface";
export interface EnrollmentApplicationItem extends MetaObject{
  action: EnrollmentApplicationAction;
  section: Section;

  // transient
  selected?: boolean;
}
