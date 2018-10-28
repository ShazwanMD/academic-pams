import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Http} from '@angular/http';
import {Observable} from 'rxjs';
import {Actor} from '../app/shared/model/identity/actor.interface';
import {environment} from '../environments/environment';
import {Staff} from '../app/shared/model/identity/staff.interface';
import {Student} from '../app/shared/model/identity/student.interface';
import { Appointment } from '../app/shared/model/term/appointment.interface';

@Injectable()
export class IdentityService {

  private IDENTITY_API: string = environment.endpoint + '/api/identity';

  constructor(private _http: HttpInterceptorService,
          private http: Http) {
  }

  findActors(): Observable<Actor[]> {
    console.log('findActors');
    return this._http.get(this.IDENTITY_API + '/actors')
      .map((res: Response) => <Actor[]>res.json());
  }

  findActorByIdentityNo(identityNo: string): Observable<Actor> {
    console.log('findActorByIdenittyNo');
    return this._http.get(this.IDENTITY_API + '/actors/' + identityNo)
      .map((res: Response) => <Actor>res.json());
  }

  findStudents(): Observable<Student[]> {
    console.log('findStudents');
    return this._http.get(this.IDENTITY_API + '/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(identityNo: string): Observable<Student> {
    console.log('findStudentByIdentityNo');
    return this._http.get(this.IDENTITY_API + '/students/' + identityNo)
      .map((res: Response) => <Student>res.json());
  }

  findStaffs(): Observable<Staff[]> {
    console.log('findStaffs');
    return this._http.get(this.IDENTITY_API + '/staffs')
      .map((res: Response) => <Staff[]>res.json());
  }

  findAcademicStaffs(): Observable<Staff[]> {
    console.log('findStaffs');
    return this._http.get(this.IDENTITY_API + '/academicStaffs')
      .map((res: Response) => <Staff[]>res.json());
  }

  findStaffByIdentityNo(identityNo: string): Observable<Staff> {
    console.log('findStaffByIdentityNo');
    return this._http.get(this.IDENTITY_API + '/staffs/' + identityNo)
      .map((res: Response) => <Staff>res.json());
  }

  //find appointments by staff
  findAppointmentsByStaff(staff: Staff): Observable<Appointment[]> {
    console.log('findAppointmentsByStaff');
    return this._http.get(this.IDENTITY_API + '/staffs/' + staff.identityNo + '/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  saveAcademicStaff(staff: Staff){
    console.log("New_Staff : " + staff.identityNo);
    return this._http.post(this.IDENTITY_API + '/academicStaffs', JSON.stringify(staff))
    .flatMap((res:Response) => Observable.of(res.text()));
  }

  updateAcademicStaff(staff: Staff){
    console.log("Update New_Staff : " + staff.identityNo);
    return this._http.put(this.IDENTITY_API + '/academicStaffs/'+staff.identityNo, JSON.stringify(staff))
    .flatMap((res:Response) => Observable.of(res.text()));
  }

  deactiveStaffAcademic(staff: Staff) {
    console.log("Front:{}"+staff.identityNo);
    return this._http.delete(this.IDENTITY_API + '/academicStaffs/' + staff.identityNo)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // findAcademicStaffs(): Observable<StaffAcademic[]> {
  //   console.log('findStaffs');
  //   return this._http.get(this.IDENTITY_API + '/academicStaffs')
  //     .map((res: Response) => <StaffAcademic[]>res.json());
  // }

  // ====================================================================================================
  // PRIVATE METHODS
  // ====================================================================================================

  private handleError(error: Response | any) {
    let body: any = error.json();
    return Observable.throw(body);
  }

}
