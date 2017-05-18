import {Document} from "../../core/document.interface";
import {Section} from "../sections/section.interface";

export interface AppointmentUpdate extends Document {

    id: null,
    status: string,
    section: Section;
    //staff: Staff;
  }
