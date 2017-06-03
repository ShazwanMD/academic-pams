import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AppointmentActions {

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
      payload: {section:section, appointment:appointment}
    };
  }
    
    
  static ADD_APPOINTMENT_SUCCESS = '[Appointment] Add Appointment Success';
  addAppointmentSuccess(message): Action {
    return {
      type: AppointmentActions.ADD_APPOINTMENT_SUCCESS,
      payload: message
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
    
      //update section for capacity and ordinal
    static UPDATE_APPOINTMENT = '[Appointment] Update Appointment';

  updateAppointment(offering, appointment): Action {
    console.log("updateAppointment");
    return {
      type: AppointmentActions.UPDATE_APPOINTMENT,
      payload: {offering:offering, appointment:appointment}
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
