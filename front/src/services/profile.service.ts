import { AcademicSession } from './../app/shared/model/planner/academic-session.interface';
import { HttpInterceptorService } from '@covalent/http';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

import { Student } from '../app/shared/model/identity/student.interface';
import { Address } from '../app/shared/model/profile/address.interface';
import { Guardian } from '../app/shared/model/profile/guardian.interface';
import { Contact } from '../app/shared/model/profile/contact.interface';
import { Guarantor } from '../app/shared/model/profile/guarantor.interface';
import { Enrollment } from '../app/shared/model/term/enrollment.interface';
import { SwitchStudyMode } from '../app/shared/model/profile/switch-study-mode.interface';
import { TransferCohort } from '../app/shared/model/profile/transfer-cohort.interface';
import { Admission } from "../app/shared/model/term/admission.interface";
import { AdmissionApplication } from "../app/shared/model/term/admission-application.interface";

@Injectable()
export class ProfileService {

  private PROFILE_API: string = environment.endpoint + '/api/profile';

  constructor(private http: Http, private _http: HttpInterceptorService) {
  }
  // ====================================================================================================
  // STUDENT - Login
  // ====================================================================================================

  findStudentByUser(): Observable<Student> {
    return this._http.get(this.PROFILE_API + '/studentLogins')
      .map((res: Response) => <Student>res.json());
  }
  findAddressessByStudent(): Observable<Address[]> {
    return this._http.get(this.PROFILE_API + '/studentLogins/addressessByStudent')
      .map((res: Response) => <Address[]>res.json());
  }

  findStudentsByIdentityNo(matricNo: string): Observable<Student> {
    return this._http.get(this.PROFILE_API + '/studentLogins/' + matricNo)
      .map((res: Response) => <Student>res.json());
  }

  findAcademicSessionByStudent(code: string): Observable<AcademicSession> {
    return this._http.get(this.PROFILE_API + '/studentLogins/academicSession' + code)
      .map((res: Response) => <AcademicSession>res.json());
  }

  /*==================================================================================================*/
  //STUDENT - ADDRESS
  /*==================================================================================================*/
  addStudentAddress(student: Student, address: Address): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/addresses', JSON.stringify(address))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudentAddress(student: Student, address: Address): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/addresses/' + address.id, JSON.stringify(address))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteStudentAddress(student: Student, address: Address) {
    return this._http.delete(this.PROFILE_API + '/students/addresses/' + address.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // STUDENT - CONTACT
  // ====================================================================================================

  addStudentContact(student: Student, contact: Contact): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/contacts', JSON.stringify(contact))
      .flatMap((res: Response) => Observable.of(res.text()));
  }
  updateStudentContact(student: Student, contact: Contact): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/contacts/' + contact.id, JSON.stringify(contact))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteStudentContact(student: Student, contact: Contact) {
    console.log('delete student contact');
    console.log("Service Student" + student);
    console.log("Service Contact" + contact);
    return this._http.delete(this.PROFILE_API + '/students/contacts/' + contact.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //STUDENT - GUARDIAN
  /*==================================================================================================*/
  addStudentGuardian(student: Student, guardian: Guardian): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/guardians', JSON.stringify(guardian))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudentGuardian(student: Student, guardian: Guardian): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/guardians/' + guardian.id, JSON.stringify(guardian))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteStudentGuardian(student: Student, guardian: Guardian) {
    return this._http.delete(this.PROFILE_API + '/students/guardians/' + guardian.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //STUDENT - GUARANTOR
  /*==================================================================================================*/
  addStudentGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/guarantors', JSON.stringify(guarantor))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudentGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/guarantors/' + guarantor.id, JSON.stringify(guarantor))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteStudentGuarantor(student: Student, guarantor: Guarantor) {
    return this._http.delete(this.PROFILE_API + '/students/guarantors/' + guarantor.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  /*STUDENT INFORMATION ADD/UPD*/
  /*==================================================================================================*/
  updateStudentDetail(student: Student): Observable<String> {
    return this._http.put(this.PROFILE_API + '/student', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // STUDENT - FINDING
  // ====================================================================================================
  findEnrollments(student: Student): Observable<Enrollment[]> {
    return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }
  
  //find admissions
  findAdmissions(student: Student): Observable<Admission[]> {
      return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/admissions')
        .map((res: Response) => <Admission[]>res.json());
    }

  findStudents(): Observable<Student[]> {
    return this._http.get(this.PROFILE_API + '/students')
      .map((res: Response) => <Student[]>res.json());
  }

  findStudentByIdentityNo(matricNo: string): Observable<Student> {
    return this._http.get(this.PROFILE_API + '/students/' + matricNo)
      .map((res: Response) => <Student>res.json());
  }

  findGuardians(student: Student): Observable<Guardian[]> {
    return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/guardians')
      .map((res: Response) => <Guardian[]>res.json());
  }

  findGuarantors(student: Student): Observable<Guarantor[]> {
    return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/guarantors')
      .map((res: Response) => <Guarantor[]>res.json());
  }

  findContacts(student: Student): Observable<Contact[]> {
    return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/contacts')
      .map((res: Response) => <Contact[]>res.json());
  }

  findAddresses(student: Student): Observable<Address[]> {
    return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/addresses')
      .map((res: Response) => <Address[]>res.json());
  }
  
  findAdmissionApplications(student: Student): Observable<AdmissionApplication[]> {
      return this._http.get(this.PROFILE_API + '/students/' + student.identityNo + '/admissionApplications')
        .map((res: Response) => <AdmissionApplication[]>res.json());
    }

  /*==================================================================================================*/
  /*STUDENT INFORMATION ADD/UPD*/
  /*==================================================================================================*/
  saveStudent(student: Student): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudent(student: Student): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/' + student.identityNo, JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }
  
  /*==================================================================================================*/
  //ADMISSION APPLICATION/ADVISORY ADD/UPD/DEL
  /*==================================================================================================*/
  
  updateAdmissionApplication(student: Student, admissionApplication: AdmissionApplication): Observable<String> {
      console.log('admissionApplication', admissionApplication);
      return this._http.put(this.PROFILE_API + '/students/' + student.identityNo + '/admissionApplications/' + admissionApplication.id, JSON.stringify(admissionApplication))
        .flatMap((res: Response) => Observable.of(res.text()));
    }

  /*==================================================================================================*/
  //ADDRESS ADD/UPD/DEL
  /*==================================================================================================*/
  addAddress(student: Student, address: Address): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/addresses', JSON.stringify(address))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAddress(student: Student, address: Address): Observable<String> {
    console.log('woi', address);
    return this._http.put(this.PROFILE_API + '/students/' + student.identityNo + '/addresses/' + address.id, JSON.stringify(address))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAddress(student: Student, address: Address) {
    return this._http.delete(this.PROFILE_API + '/students/' + student.identityNo + '/addresses/' + address.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //GUARDIAN ADD/UPD/DEL
  /*==================================================================================================*/
  addGuardian(student: Student, guardian: Guardian): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/guardians', JSON.stringify(guardian))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGuardian(student: Student, guardian: Guardian): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/' + student.identityNo + '/guardians/' + guardian.id, JSON.stringify(guardian))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteGuardian(student: Student, guardian: Guardian) {
    return this._http.delete(this.PROFILE_API + '/students/' + student.identityNo + '/guardians/' + guardian.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //GUARANTOR ADD/UPD/DEL
  /*==================================================================================================*/
  addGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/guarantors', JSON.stringify(guarantor))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGuarantor(student: Student, guarantor: Guarantor): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/' + student.identityNo + '/guarantors/' + guarantor.id, JSON.stringify(guarantor))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteGuarantor(student: Student, guarantor: Guarantor) {
    return this._http.delete(this.PROFILE_API + '/students/' + student.identityNo + '/guarantors/' + guarantor.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*==================================================================================================*/
  //CONTACT ADD/UPD/DEL
  /*==================================================================================================*/
  addContact(student: Student, contact: Contact): Observable<String> {
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/contacts', JSON.stringify(contact))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateContact(student: Student, contact: Contact): Observable<String> {
    return this._http.put(this.PROFILE_API + '/students/' + student.identityNo + '/contacts/' + contact.id, JSON.stringify(contact))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteContact(student: Student, contact: Contact) {
    console.log('delete contact');
    return this._http.delete(this.PROFILE_API + '/students/' + student.identityNo + '/contacts/' + contact.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }



  /*==================================================================================================*/
  //STUDENT ACTIVATION/DEACTIVATE/BAR/TRANSFER/SWITCH
  /*==================================================================================================*/
  deactivateStudent(student: Student): Observable<String> {
    console.log('deactivate student');
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/deactivate', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  activateStudent(student: Student): Observable<String> {
    console.log('activate student');
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/activate', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  barStudent(student: Student): Observable<String> {
    console.log('bar student');
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/barStudent', JSON.stringify(student))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  switchStudyMode(student: Student, switcher: SwitchStudyMode): Observable<String> {
    console.log(switcher);
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/switchStudyMode', JSON.stringify(switcher))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  transferCohort(student: Student, transferer: TransferCohort): Observable<String> {
    console.log(transferer);
    return this._http.post(this.PROFILE_API + '/students/' + student.identityNo + '/transferCohort', JSON.stringify(transferer))
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // PRIVATE METHODS
  // ====================================================================================================

  private handleError(error: Response | any) {
    let body: any = error.json();
    return Observable.throw(body);
  }
}
