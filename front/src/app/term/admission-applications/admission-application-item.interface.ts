import {Section} from "../sections/section.interface";
import {AdmissionApplicationAction} from "./admission-application-action.enum";
export interface AdmissionApplicationItem {
  action: AdmissionApplicationAction;
  section: Section;
}
