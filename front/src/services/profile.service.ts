import { Injectable } from '@angular/core';
import {Response, Http} from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';
import {Student} from "../app/identity/student.interface";
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {Guardian} from "../app/profile/guardian.interface";
import {Address} from "../app/profile/address.interface";
import {Contact} from "../app/profile/contact.interface";
import {Guarantor} from "../app/profile/guarantor.interface";

@Injectable()
export class ProfileService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // STUDENT
  // ====================================================================================================

  findStudents(): Observable<Student[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByMatricNo(matricNo: string): Observable<Student> {
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    console.log("encoded uri: " + encodeURI (matricNo))
    return this.http.get(environment.endpoint + '/api/profile/students/'  + matricNo)
      .map((res: Response) => <Student>res.json());
  }

  findGuardians(student:Student): Observable<Guardian[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/guardians")
      .map((res: Response) => <Guardian[]>res.json());
  }

  findGuarantors(student:Student): Observable<Guarantor[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/guarantors")
      .map((res: Response) => <Guarantor[]>res.json());
  }

  findContacts(student:Student): Observable<Contact[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/contacts")
      .map((res: Response) => <Contact[]>res.json());
  }

  findAddresses(student:Student): Observable<Address[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/addresses")
      .map((res: Response) => <Address[]>res.json());
  }

  saveStudent(student: Student): Observable<Boolean> {
    return this.http.post(environment.endpoint + '/api/profile/students', JSON.stringify(student))
      .flatMap(data => Observable.of(true));
  }

  updateStudent(student: Student): Observable<Boolean> {
    return this.http.put(environment.endpoint + '/api/profile/students', JSON.stringify(student))
      .flatMap(data => Observable.of(true));
  }

}
