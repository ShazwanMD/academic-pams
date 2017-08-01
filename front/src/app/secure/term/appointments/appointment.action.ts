import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AppointmentActions {

  //find appointments
  static FIND_APPOINTMENTS = '[Appointment] Find Appointments';

  findAppointments(): Action {
    return {
      type: AppointmentActions.FIND_APPOINTMENTS
    };
  }

  static FIND_APPOINTMENTS_SUCCESS = '[Appointment] Find Appointments Success';

  findAppointmentsSuccess(appointments): Action {
    return {
      type: AppointmentActions.FIND_APPOINTMENTS_SUCCESS,
      payload: appointments
    };
  }

  static FIND_APPOINTMENT_BY_ID = '[Appointment] Find Appointment By Id';

  findAppointmentById(appointment): Action {
    return {
      type: AppointmentActions.FIND_APPOINTMENT_BY_ID,
      payload: appointment
    };
  }

  static FIND_APPOINTMENT_BY_ID_SUCCESS = '[Appointment] Find Appointment By Id Success';

  findAppointmentByIdSuccess(appointment): Action {
    return {
      type: AppointmentActions.FIND_APPOINTMENT_BY_ID_SUCCESS,
      payload: appointment
    };
  }

  //find appointments by section
  static FIND_APPOINTMENTS_BY_SECTION = '[Appointment] Find Appointments By Section';

  findAppointmentsBySection(section): Action {
    console.log("findAppointmentsBySection");
    return {
      type: AppointmentActions.FIND_APPOINTMENTS_BY_SECTION,
      payload: section
    };
  }

  static FIND_APPOINTMENTS_BY_SECTION_SUCCESS = '[Appointment] Find Appointments By Section Success';

  findAppointmentsBySectionSuccess(appointments): Action {
    console.log("findAppointmentsBySectionSuccess");
    return {
      type: AppointmentActions.FIND_APPOINTMENTS_BY_SECTION_SUCCESS,
      payload: appointments
    };
  }

  static ADD_APPOINTMENT = '[Appointment] Add Appointment';

  addAppointment(section, appointment): Action {
    return {
      type: AppointmentActions.ADD_APPOINTMENT,
      payload: {section: section, appointment: appointment}
    };
  }


  static ADD_APPOINTMENT_SUCCESS = '[Appointment] Add Appointment Success';

  addAppointmentSuccess(message): Action {
    return {
      type: AppointmentActions.ADD_APPOINTMENT_SUCCESS,
      payload: {status: message}
    };
  }

  //remove appointment
  static REMOVE_APPOINTMENT = '[Appointment] Remove Appointment';

  removeAppointment(section, appointment): Action {
    console.log("removeAppointment");
    return {
      type: AppointmentActions.REMOVE_APPOINTMENT,
      payload: {section: section, appointment: appointment}
    };
  }

  static REMOVE_APPOINTMENT_SUCCESS = '[Appointment] Remove Appointment Success';

  removeAppointmentSuccess(message): Action {
    console.log("removeAppointmentSuccess");
    return {
      type: AppointmentActions.REMOVE_APPOINTMENT_SUCCESS,
      payload: message
    };
  }

  //update section for capacity and ordinal
  static UPDATE_APPOINTMENT = '[Appointment] Update Appointment';

  updateAppointment(section, appointment): Action {
    console.log("updateAppointment");
    return {
      type: AppointmentActions.UPDATE_APPOINTMENT,
      payload: {section: section, appointment: appointment}
    };
  }

  static UPDATE_APPOINTMENT_SUCCESS = '[Appointment] Update Appointment Success';

  updateAppointmentSuccess(message): Action {
    console.log("updateAppointmentSuccess");
    return {
      type: AppointmentActions.UPDATE_APPOINTMENT_SUCCESS,
      payload: message
    };
  }

}
