import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AppointmentActions {

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
  findAppointmentById(id): Action {
    return {
      type: AppointmentActions.FIND_APPOINTMENT_BY_ID,
      payload: id
    };
  }

  static FIND_APPOINTMENT_BY_ID_SUCCESS = '[Appointment] Find Appointment By Id Success';
  findAppointmentByIdSuccess(appointment): Action {
    return {
      type: AppointmentActions.FIND_APPOINTMENT_BY_ID_SUCCESS,
      payload: appointment
    };
  }

  static SAVE_APPOINTMENT = '[Appointment] Save Appointment';
  saveAppointment(appointment): Action {
    return {
      type: AppointmentActions.SAVE_APPOINTMENT,
      payload: appointment
    };
  }

  static SAVE_APPOINTMENT_SUCCESS = '[Appointment] Save Appointment Success';
  saveAppointmentSuccess(appointment): Action {
    return {
      type: AppointmentActions.SAVE_APPOINTMENT_SUCCESS,
      payload: appointment
    };
  }

  static REMOVE_APPOINTMENT = '[Appointment] Remove Appointment';
  removeAppointment(appointment): Action {
    return {
      type: AppointmentActions.REMOVE_APPOINTMENT,
      payload: appointment
    };
  }

  static REMOVE_APPOINTMENT_SUCCESS = '[Appointment] Remove Appointment Success';
  removeAppointmentSuccess(appointment): Action {
    return {
      type: AppointmentActions.REMOVE_APPOINTMENT_SUCCESS,
      payload: appointment
    };
  }
}
