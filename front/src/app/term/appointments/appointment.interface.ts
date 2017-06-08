import {Section} from "../sections/section.interface";
import {Student} from "../../identity/student.interface";
// import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {Staff} from "../../identity/staff.interface";
import {Actor} from "../../identity/actor.interface";
import { AcademicSession } from "../../planner/academic-sessions/academic-session.interface";
import { Offering } from "../offerings/offering.interface";
import { Course } from "../../planner/courses/course.interface";
import {AppointmentStatus} from "./appointment-status.enum";

export interface Appointment {
    id: number;
    staff: Actor;
    section: Section;
    session: AcademicSession;
    offering: Offering;
    course: Course;
    appointmentStatus: AppointmentStatus;

 // transient
  selected: boolean;

}
