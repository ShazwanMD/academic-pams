import {Section} from './section.interface';
import {AcademicSession} from '../planner/academic-session.interface';
import {Offering} from './offering.interface';
import {Course} from '../planner/course.interface';
import {AppointmentStatus} from './appointment-status.enum';
import {Actor} from '../identity/actor.interface';
import {MetaObject} from '../../../core/meta-object.interface';

export interface Appointment extends MetaObject{
  staff: Actor;
  section: Section;
  session: AcademicSession;
  offering: Offering;
  course: Course;
  appointmentStatus: AppointmentStatus;

  // transient
  selected: boolean;

}
