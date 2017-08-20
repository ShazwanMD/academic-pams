import { Observable } from 'rxjs';
import { Staff } from './../app/shared/model/identity/staff.interface';
import { HttpInterceptorService } from '@covalent/http';
import { Http, Response } from '@angular/http';
import { environment } from './../environments/environment';
import { Injectable } from '@angular/core';
import { Appointment } from '../app/shared/model/term/appointment.interface';

@Injectable()
export class LecturerPanelService {
    private LECTURER_API: string = environment.endpoint + '/api/lecturer';

    constructor(private http: Http, private _http: HttpInterceptorService) {

    }

    // ====================================================================================================
    // LECTURER - LOGIN
    // ====================================================================================================


    findLecturerByUser(): Observable<Staff> {
        return this._http.get(this.LECTURER_API + '/lecturerLogin')
        .map((res: Response) => <Staff>res.json());
        }
    
    //find appointments by lecturer
    findAppointments(lecturer: Staff): Observable<Appointment[]> {
        return this._http.get(this.LECTURER_API + '/lecturers/' + lecturer.identityNo + '/appointments')
          .map((res: Response) => <Appointment[]>res.json());
      }
    
}