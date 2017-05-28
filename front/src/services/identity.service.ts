import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {Actor} from "../app/identity/actor.interface";
import {environment} from "../environments/environment";
import {Staff} from "../app/identity/staff.interface";
import {Student} from "../app/identity/student.interface";

@Injectable()
export class IdentityService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  findActors(): Observable<Actor[]> {
    console.log("findActors");
    return this.http.get(environment.endpoint + '/api/identity/actors')
      .map((res: Response) => <Actor[]>res.json());
  }

  findActorByIdentityNo(identityNo: string): Observable<Actor> {
    console.log("findActorByIdenittyNo");
    return this.http.get(environment.endpoint + '/api/identity/actors/' + identityNo)
      .map((res: Response) => <Actor>res.json());
  }

  findStudents(): Observable<Student[]> {
    console.log("findStudents");
    return this.http.get(environment.endpoint + '/api/identity/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(identityNo: string): Observable<Student> {
    console.log("findStudentByIdentityNo");
    return this.http.get(environment.endpoint + '/api/identity/students/' + identityNo)
      .map((res: Response) => <Student>res.json());
  }

  findStaffs(): Observable<Staff[]> {
    console.log("findStaffs");
    return this.http.get(environment.endpoint + '/api/identity/staffs')
      .map((res: Response) => <Staff[]>res.json());
  }

  findStaffByIdentityNo(identityNo: string): Observable<Staff> {
    console.log("findStaffByIdentityNo");
    return this.http.get(environment.endpoint + '/api/identity/staffs/' + identityNo)
      .map((res: Response) => <Staff>res.json());
  }
}
