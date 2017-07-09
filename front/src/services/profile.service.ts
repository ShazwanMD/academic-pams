import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

import {Student} from '../app/identity/student.interface';
import {Address} from '../app/profile/address.interface';
import {Guardian} from '../app/profile/guardian.interface';
import {Contact} from '../app/profile/contact.interface';
import {Guarantor} from '../app/profile/guarantor.interface';
import {Enrollment} from '../app/term/enrollments/enrollment.interface';
import {SwitchStudyMode} from '../app/profile/switch-study-mode.interface';
import {TransferCohort} from '../app/profile/transfer-cohort.interface';

@Injectable()
export class ProfileService {

  private profile_api: string = environment.endpoint + '/api/profile';

  constructor(private _http: Http) {
  }

  // ====================================================================================================
  // STUDENT - FINDING
  // ====================================================================================================
  findEnrollments(student: Student): Observable<Enrollment[]> {
    return this._http.get(this.profile_api + '/students/' + student.identityNo + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findStudents(): Observable<Student[]> {
    return this._http.get(this.profile_api + '/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(matricNo: string): Observable<Student> {
    return this._http.get(this.profile_api + '/students/' + matricNo)
      .map((res: Response) => <Student>res.json());
  }

  findGuardians(student: Student): Observable<Guardian[]> {
    return this._http.get(this.profile_api + '/students/' + student.identityNo + '/guardians')
      .map((res: Response) => <Guardian[]>res.json());
  }

  findGuarantors(student: Student): Observable<Guarantor[]> {
    return this._http.get(this.profile_api + '/students/' + student.identityNo + '/guarantors')
      .map((res: Response) => <Guarantor[]>res.json());
  }

  findContacts(student: Student): Observable<Contact[]> {
    return this._http.get(this.profile_api + '/students/' + student.identityNo + '/contacts')
      .map((res: Response) => <Contact[]>res.json());
  }

  findAddresses(student: Student): Observable<Address[]> {
    return this._http.get(this.profile_api + '/students/' + student.identityNo + '/addresses')
      .map((res: Response) => <Address[]>res.json());
  }

  /*==================================================================================================*/
  /*STUDENT INFORMATION ADD/UPD*/
  /*==================================================================================================*/
  saveStudent(student: Student): Observable<String> {
    return this._http.post(this.profile_api + '/students', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudent(student: Student): Observable<String> {
    return this._http.put(this.profile_api + '/students/' + student.identityNo, JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //ADDRESS ADD/UPD/DEL
  /*==================================================================================================*/
  addAddress(student: Student, address: Address): Observable<String> {
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/addresses', JSON.stringify(address))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAddress(student: Student, address: Address): Observable<String> {
    console.log('woi', address);
    return this._http.put(this.profile_api + '/students/' + student.identityNo + '/addresses/' + address.id, JSON.stringify(address))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAddress(student: Student, address: Address) {
    return this._http.delete(this.profile_api + '/students/' + student.identityNo + '/addresses/' + address.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //GUARDIAN ADD/UPD/DEL
  /*==================================================================================================*/
  addGuardian(student: Student, guardian: Guardian): Observable<String> {
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/guardians', JSON.stringify(guardian))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGuardian(student: Student, guardian: Guardian): Observable<String> {
    return this._http.put(this.profile_api + '/students/' + student.identityNo + '/guardians/' + guardian.id, JSON.stringify(guardian))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteGuardian(student: Student, guardian: Guardian) {
    return this._http.delete(this.profile_api + '/students/' + student.identityNo + '/guardians/' + guardian.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //GUARANTOR ADD/UPD/DEL
  /*==================================================================================================*/
  addGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/guarantors', JSON.stringify(guarantor))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    return this._http.put(this.profile_api + '/students/' + student.identityNo + '/guarantors/' + guarantor.id, JSON.stringify(guarantor))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteGuarantor(student: Student, guarantor: Guarantor) {
    return this._http.delete(this.profile_api + '/students/' + student.identityNo + '/guarantors/' + guarantor.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //CONTACT ADD/UPD/DEL
  /*==================================================================================================*/
  addContact(student: Student, contact: Contact): Observable<String> {
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/contacts', JSON.stringify(contact))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateContact(student: Student, contact: Contact): Observable<String> {
    return this._http.put(this.profile_api + '/students/' + student.identityNo + '/contacts/' + contact.id, JSON.stringify(contact))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteContact(student: Student, contact: Contact) {
    console.log('delete contact');
    return this._http.delete(this.profile_api + '/students/' + student.identityNo + '/contacts/' + contact.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //STUDENT ACTIVATION/DEACTIVATE/BAR/TRANSFER/SWITCH
  /*==================================================================================================*/
  deactivateStudent(student: Student): Observable<String> {
    console.log('deactivate student');
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/deactivate', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  activateStudent(student: Student): Observable<String> {
    console.log('activate student');
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/activate', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  barStudent(student: Student): Observable<String> {
    console.log('bar student');
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/barStudent', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  switchStudyMode(student: Student, switcher: SwitchStudyMode): Observable<String> {
    console.log(switcher);
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/switchStudyMode', JSON.stringify(switcher))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  transferCohort(student: Student, transferer: TransferCohort): Observable<String> {
    console.log(transferer);
    return this._http.post(this.profile_api + '/students/' + student.identityNo + '/transferCohort', JSON.stringify(transferer))
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
