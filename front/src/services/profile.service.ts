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
import {SwitchStudyMode} from "../app/profile/switch-study-mode.interface";
import {TransferCohort} from "../app/profile/transfer-cohort.interface";

@Injectable()
export class ProfileService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // STUDENT - FINDING
  // ====================================================================================================
  findEnrollments(student: Student): Observable<Enrollment[]> {
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/enrollments")
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findStudents(): Observable<Student[]> {
    return this.http.get(environment.endpoint + '/api/profile/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(matricNo: string): Observable<Student> {
    return this.http.get(environment.endpoint + '/api/profile/students/' + matricNo)
      .map((res: Response) => <Student>res.json());
  }

  findGuardians(student: Student): Observable<Guardian[]> {
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/guardians")
      .map((res: Response) => <Guardian[]>res.json());
  }

  findGuarantors(student: Student): Observable<Guarantor[]> {
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/guarantors")
      .map((res: Response) => <Guarantor[]>res.json());
  }

  findContacts(student: Student): Observable<Contact[]> {
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/contacts")
      .map((res: Response) => <Contact[]>res.json());
  }

  findAddresses(student: Student): Observable<Address[]> {
    return this.http.get(environment.endpoint + '/api/profile/students/' + student.identityNo + "/addresses")
      .map((res: Response) => <Address[]>res.json());
  }

  /*==================================================================================================*/
  /*STUDENT INFORMATION ADD/UPD*/
  /*==================================================================================================*/
  saveStudent(student: Student): Observable<String> {
    return this.http.post(environment.endpoint + '/api/profile/students', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudent(student: Student): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo, JSON.stringify(student), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //ADDRESS ADD/UPD/DEL
  /*==================================================================================================*/
  addAddress(student: Student, address: Address): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/addresses', JSON.stringify(address), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAddress(student: Student, address: Address): Observable<String> {
    console.log("woi", address);
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo + '/addresses/' + address.id, JSON.stringify(address), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAddress(student: Student, address: Address) {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/profile/students/' + student.identityNo + '/addresses/' + address.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //GUARDIAN ADD/UPD/DEL
  /*==================================================================================================*/
  addGuardian(student: Student, guardian: Guardian): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guardians', JSON.stringify(guardian), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGuardian(student: Student, guardian: Guardian): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guardians/' + guardian.id, JSON.stringify(guardian), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteGuardian(student: Student, guardian: Guardian) {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guardians/' + guardian.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //GUARANTOR ADD/UPD/DEL
  /*==================================================================================================*/
  addGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guarantors', JSON.stringify(guarantor), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guarantors/' + guarantor.id, JSON.stringify(guarantor), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteGuarantor(student: Student, guarantor: Guarantor) {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/profile/students/' + student.identityNo + '/guarantors/' + guarantor.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //CONTACT ADD/UPD/DEL
  /*==================================================================================================*/
  addContact(student: Student, contact: Contact): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/contacts', JSON.stringify(contact), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateContact(student: Student, contact: Contact): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/profile/students/' + student.identityNo + '/contacts/' + contact.id, JSON.stringify(contact), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteContact(student: Student, contact: Contact) {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    console.log("delete contact");
    return this.http.delete(environment.endpoint + '/api/profile/students/' + student.identityNo + '/contacts/' + contact.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //STUDENT ACTIVATION/DEACTIVATE/BAR/TRANSFER/SWITCH
  /*==================================================================================================*/
  deactivateStudent(student: Student): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate student");
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/deactivate', options)
      .map((res: Response) => <String>res.json());
  }

  activateStudent(student: Student): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate student");
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/activate', options)
      .map((res: Response) => <String>res.json());
  }

  barStudent(student: Student): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("bar student");
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/barStudent', options)
      .map((res: Response) => <String>res.json());
  }

  switchStudyMode(student: Student, switcher: SwitchStudyMode) {
    console.log("switchStudyMode");
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/switchStudyMode', JSON.stringify(switcher), options)
      .map((res: Response) => <String>res.json());
  }

  transferCohort(student: Student, transferer: TransferCohort) {
    console.log("transferCohort");
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/profile/students/' + student.identityNo + '/transferCohort', JSON.stringify(transferer), options)
      .map((res: Response) => <String>res.json());
  }
}
