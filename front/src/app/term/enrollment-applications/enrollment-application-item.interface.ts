import {Section} from "../sections/section.interface";
import {EnrollmentApplicationAction} from "./enrollment-application-action.enum";
export interface EnrollmentApplicationItem {
  action: EnrollmentApplicationAction;
  section: Section;

  // transient
  selected?: boolean;
}
