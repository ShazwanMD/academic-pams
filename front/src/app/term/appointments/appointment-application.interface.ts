import {Document} from "../../core/document.interface";

import {Actor} from "../../identity/actor.interface";
import {Section} from "../sections/section.interface";
export interface AppointmentApplication extends Document {

    id: null,
    status: string,
    section: Section;
    //staff: Actor;

}
