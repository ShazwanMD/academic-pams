import {Injectable} from '@angular/core';
import {Headers} from '@angular/http';
import {Response, Http, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {environment} from "../environments/environment";

import {Student} from "../app/identity/student.interface";
import {Address} from './../app/profile/address.interface';
import {Guardian} from "../app/profile/guardian.interface";
import {Contact} from "../app/profile/contact.interface";
import {Guarantor} from "../app/profile/guarantor.interface";
import {Enrollment} from './../app/term/enrollments/enrollment.interface';

@Injectable()
export class ProfileService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // STUDENT
  // ====================================================================================================
  findEnrollments(student: Student): Observable<Enrollment[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/enrollments")
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findStudents(): Observable<Student[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(matricNo: string): Observable<Student> {
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + matricNo)
      .map((res: Response) => <Student>res.json());
  }

  findGuardians(student: Student): Observable<Guardian[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/guardians")
      .map((res: Response) => <Guardian[]>res.json());
  }

  findGuarantors(student: Student): Observable<Guarantor[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/guarantors")
      .map((res: Response) => <Guarantor[]>res.json());
  }

  findContacts(student: Student): Observable<Contact[]> {
    console.log("findStudents");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/contacts")
      .map((res: Response) => <Contact[]>res.json());
  }

  findAddresses(student: Student): Observable<Address[]> {
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/addresses")
      .map((res: Response) => <Address[]>res.json());
  }

  saveStudent(student: Student): Observable<String> {
    return this.http.post(environment.endpoint + '/api/profile/students', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudent(student: Student): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo, JSON.stringify(student), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addContact(student: Student, contact: Contact): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/contacts', JSON.stringify(contact), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addAddress(student: Student, address: Address): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/addresses', JSON.stringify(address), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAddress(student: Student, address: Address): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo + '/addresses', JSON.stringify(address), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addGuardian(student: Student, guardian: Guardian): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guardians', JSON.stringify(guardian), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guarantors', JSON.stringify(guarantor), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

   deleteContact(student: Student, contact: Contact) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/profile/students/'  + student.identityNo + '/contacts', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
