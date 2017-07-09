import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs';
import {Actor} from '../app/identity/actor.interface';
import {environment} from '../environments/environment';
import {Staff} from '../app/identity/staff.interface';
import {Student} from '../app/identity/student.interface';

@Injectable()
export class IdentityService {

  private identity_api: string = environment.endpoint + '/api/identity';

  constructor(private _http: HttpInterceptorService) {
  }

  findActors(): Observable<Actor[]> {
    console.log('findActors');
    return this._http.get(this.identity_api + '/actors')
      .map((res: Response) => <Actor[]>res.json());
  }

  findActorByIdentityNo(identityNo: string): Observable<Actor> {
    console.log('findActorByIdenittyNo');
    return this._http.get(this.identity_api + '/actors/' + identityNo)
      .map((res: Response) => <Actor>res.json());
  }

  findStudents(): Observable<Student[]> {
    console.log('findStudents');
    return this._http.get(this.identity_api + '/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(identityNo: string): Observable<Student> {
    console.log('findStudentByIdentityNo');
    return this._http.get(this.identity_api + '/students/' + identityNo)
      .map((res: Response) => <Student>res.json());
  }

  findStaffs(): Observable<Staff[]> {
    console.log('findStaffs');
    return this._http.get(this.identity_api + '/staffs')
      .map((res: Response) => <Staff[]>res.json());
  }

  findStaffByIdentityNo(identityNo: string): Observable<Staff> {
    console.log('findStaffByIdentityNo');
    return this._http.get(this.identity_api + '/staffs/' + identityNo)
      .map((res: Response) => <Staff>res.json());
  }
}
