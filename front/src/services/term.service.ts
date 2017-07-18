import {Course} from '../app/planner/courses/course.interface';
import {Program} from '../app/planner/programs/program.interface';
import {AdmissionApplication} from '../app/term/admission-applications/admission-application.interface';
import {Assessment} from '../app/term/assessments/assessment.interface';
import {Offering} from '../app/term/offerings/offering.interface';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {RequestOptions, Response, ResponseContentType, Headers} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/filter';
import {environment} from '../environments/environment';
import {EnrollmentApplication} from '../app/term/enrollment-applications/enrollment-application.interface';
import {EnrollmentApplicationItem} from '../app/term/enrollment-applications/enrollment-application-item.interface';
import {EnrollmentApplicationTask} from '../app/term/enrollment-applications/enrollment-application-task.interface';
import {Admission} from '../app/term/admissions/admission.interface';
import {Enrollment} from '../app/term/enrollments/enrollment.interface';
import {AdmissionApplicationTask} from '../app/term/admission-applications/admission-application-task.interface';
import {Appointment} from '../app/term/appointments/appointment.interface';
import {Section} from '../app/term/sections/section.interface';
import {GradebookMatrix} from '../app/term/offerings/gradebook-matrix.interface';
import { Gradebook } from "../app/term/gradebooks/gradebook.interface";

@Injectable()
export class TermService {

  private TERM_API: string = environment.endpoint + '/api/term';

  constructor(private _http: HttpInterceptorService,
              private http: Http) {
  }

  findAssessmentById(id: number): Observable<Assessment> {
    console.log('findAssessmentById');
    return this._http.get(this.TERM_API + '/assessments/' + id)
      .map((res: Response) => <Assessment>res.json());
  }

  findAssessments(): Observable<Assessment[]> {
    console.log('findAssessments');
    return this._http.get(this.TERM_API + '/assessments')
      .map((res: Response) => <Assessment[]>res.json());
  }

  addAssessment(offering: Offering, assessment: Assessment): Observable<String> {
    console.log('addAssessment:' + assessment);
    console.log('offering:' + offering.canonicalCode);
    return this._http.post(this.TERM_API + '/offerings/' + offering.canonicalCode + '/assessments', JSON.stringify(assessment))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAssessment(offering: Offering, assessment: Assessment): Observable<String> {
    console.log(assessment);
    console.log('addOffering:' + offering.canonicalCode);
    return this._http.put(this.TERM_API + '/offerings/' + offering.canonicalCode + '/assessments/' + assessment.id, JSON.stringify(assessment))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAssessment(offering: Offering, assessment: Assessment): Observable<String> {
    console.log('deleteAssessmentInService')
    return this._http.delete(this.TERM_API + '/offerings/' + offering.canonicalCode + '/assessments/' + assessment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ADMISSION APPLICATION
  // ==================================================================================================== //

  findAdmissionApplications(): Observable<AdmissionApplication[]> {
    console.log('findAdmissionApplication');
    return this._http.get(this.TERM_API + '/admissionApplications/')
      .map((res: Response) => <AdmissionApplication[]>res.json());

  }

  findAssignedAdmissionApplicationTasks(): Observable<AdmissionApplicationTask[]> {
    console.log('findAssignedAdmissionApplicationTasks');
    return this._http.get(this.TERM_API + '/admissionApplications/assignedTasks')
      .map((res: Response) => <AdmissionApplicationTask[]>res.json());
  }

  findPooledAdmissionApplicationTasks(): Observable<AdmissionApplicationTask[]> {
    console.log('findPooledAdmissionApplicationTasks');
    return this._http.get(this.TERM_API + '/admissionApplications/pooledTasks')
      .map((res: Response) => <AdmissionApplicationTask[]>res.json());
  }

  findArchivedAdmissionApplications(): Observable<AdmissionApplication[]> {
    console.log('findArchivedAdmissionApplications');
    return this._http.get(this.TERM_API + '/admissionApplications/archived')
      .map((res: Response) => <AdmissionApplication[]>res.json());
  }

  findAdmissionApplicationTaskByTaskId(taskId: string): Observable<AdmissionApplicationTask> {
    console.log('findAdmissionApplicationTaskByTaskId');
    return this._http.get(this.TERM_API + '/admissionApplications/viewTask/' + taskId)
      .map((res: Response) => <AdmissionApplicationTask>res.json());
  }

  findAdmissionApplicationByTaskId(taskId: string): Observable<AdmissionApplication> {
    return this._http.get(this.TERM_API + '/admissionApplications/' + taskId)
      .map((res: Response) => <AdmissionApplication>res.json());
  }

  startAdmissionApplicationTask(admissionApplication: AdmissionApplication): Observable<String> {
    console.log('start task');
    return this._http.post(this.TERM_API + '/admissionApplications/startTask', JSON.stringify(admissionApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAdmissionApplication(application: AdmissionApplication): Observable<String> {
    console.log('update admission app:' + application.referenceNo);
    console.log(JSON.stringify(application));
    return this._http.put(this.TERM_API + '/admissionApplications/' + application.referenceNo + '/update', JSON.stringify(application))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  saveAdmissionApplication(admissionApplication: AdmissionApplication): Observable<String> {
    return this._http.post(this.TERM_API + '/admissionApplications' + '/save', JSON.stringify(admissionApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findAdmissionApplicationByReferenceNo(referenceNo: string): Observable<AdmissionApplication> {
    return this._http.get(this.TERM_API + '/admissionApplications/' + referenceNo)
      .map((res: Response) => <AdmissionApplication>res.json());
  }

  completeAdmissionApplicationTask(admissionApplicationTask: AdmissionApplicationTask): Observable<String> {
    console.log('TaskId: ' + admissionApplicationTask.taskId);
    return this._http.post(this.TERM_API + '/admissionApplications/completeTask', JSON.stringify(admissionApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimAdmissionApplicationTask(admissionApplicationTask: AdmissionApplicationTask): Observable<String> {
    return this._http.post(this.TERM_API + '/admissionApplications/claimTask', JSON.stringify(admissionApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseAdmissionApplicationTask(admissionApplicationTask: AdmissionApplicationTask): Observable<String> {
    return this._http.post(this.TERM_API + '/admissionApplications/releaseTask', JSON.stringify(admissionApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ADMISSION
  // ==================================================================================================== //

  findAdmissions(): Observable<Admission[]> {
    console.log('findAdmissions');
    return this._http.get(this.TERM_API + '/admissions')
      .map((res: Response) => <Admission[]>res.json());
  }

  findCurrentAdmissions(): Observable<Admission[]> {
    console.log('findCurrentAdmissions');
    return this._http.get(this.TERM_API + '/admissions/current')
      .map((res: Response) => <Admission[]>res.json());
  }

  findAdmissionById(id: number): Observable<Admission> {
    console.log('findAdmissionById');
    return this._http.get(this.TERM_API + '/admissions/' + id)
      .map((res: Response) => <Admission>res.json());
  }

  findEnrollmentsByAdmission(admission: Admission): Observable<Enrollment[]> {
    console.log('findEnrollmentsByAdmission');
    return this._http.get(this.TERM_API + '/admissions/' + admission.id + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findEnrollmentApplicationsByAdmission(admission: Admission): Observable<EnrollmentApplication[]> {
    console.log('findEnrollmentApplicationsByAdmission');
    return this._http.get(this.TERM_API + '/admissions/' + admission.id + '/enrollmentApplications')
      .map((res: Response) => <EnrollmentApplication[]>res.json());
  }

  saveAdmission(admission: Admission): Observable<String> {
    console.log('saveAdmission');
    return this._http.post(this.TERM_API + '/admissions', JSON.stringify(admission))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAdmission(admission: Admission): Observable<String> {
    console.log('updateAdmission');
    return this._http.put(this.TERM_API + '/admissions/' + admission.id, JSON.stringify(admission))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ENROLLMENT APPLICATION
  // ==================================================================================================== //

  findAssignedEnrollmentApplicationTasks(): Observable<EnrollmentApplicationTask[]> {
    console.log('findAssignedEnrollmentApplicationTasks');
    return this._http.get(this.TERM_API + '/enrollmentApplications/assignedTasks')
      .map((res: Response) => <EnrollmentApplicationTask[]>res.json());
  }

  findPooledEnrollmentApplicationTasks(): Observable<EnrollmentApplicationTask[]> {
    console.log('findPooledEnrollmentApplicationTasks');
    return this._http.get(this.TERM_API + '/enrollmentApplications/pooledTasks')
      .map((res: Response) => <EnrollmentApplicationTask[]>res.json());
  }

  findArchivedEnrollmentApplications(): Observable<EnrollmentApplication[]> {
    console.log('findArchivedEnrollmentApplications');
    return this._http.get(this.TERM_API + '/enrollmentApplications/archived')
      .map((res: Response) => <EnrollmentApplication[]>res.json());
  }

  findEnrollmentApplicationTaskByTaskId(taskId: string): Observable<EnrollmentApplicationTask> {
    console.log('findEnrollmentApplicationTaskByTaskId');
    return this._http.get(this.TERM_API + '/enrollmentApplications/viewTask/' + taskId)
      .map((res: Response) => <EnrollmentApplicationTask>res.json());
  }

  findEnrollmentApplicationByTaskId(taskId: string): Observable<EnrollmentApplication> {
    return this._http.get(this.TERM_API + '/enrollmentApplications/' + taskId)
      .map((res: Response) => <EnrollmentApplication>res.json());
  }

  startEnrollmentApplicationTask(enrollmentApplication: EnrollmentApplication): Observable<String> {
    console.log('proses startEnrollmentApplicationTask');
    return this._http.post(this.TERM_API + '/enrollmentApplications/startTask', JSON.stringify(enrollmentApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  completeEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
    console.log('TaskId: ' + enrollmentApplicationTask.taskId);
    return this._http.post(this.TERM_API + '/enrollmentApplications/completeTask', JSON.stringify(enrollmentApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  /*removeEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
   console.log("TaskId: " + enrollmentApplicationTask.taskId);
   return this._http.delete(this.TERM_API + '/enrollmentApplications/deleteTask', JSON.stringify(enrollmentApplicationTask))
   .flatMap((res: Response) => Observable.of(res.text()));
   }*/

  claimEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
    return this._http.post(this.TERM_API + '/enrollmentApplications/claimTask', JSON.stringify(enrollmentApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
    return this._http.post(this.TERM_API + '/enrollmentApplications/releaseTask', JSON.stringify(enrollmentApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateEnrollmentApplication(enrollmentApplication: EnrollmentApplication): Observable<String> {
    return this._http.put(this.TERM_API + '/enrollmentApplications', JSON.stringify(enrollmentApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addEnrollmentApplicationItem(enrollmentApplication: EnrollmentApplication, item: EnrollmentApplicationItem): Observable<String> {
    return this._http.post(this.TERM_API + '/enrollmentApplications/' + enrollmentApplication.referenceNo
      + '/enrollmentApplicationItems', JSON.stringify(item))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateEnrollmentApplicationItem(application: EnrollmentApplication, item: EnrollmentApplicationItem): Observable<String> {
    console.log(item);
    return this._http.put(this.TERM_API + '/enrollmentApplications/' + application.referenceNo
      + '/enrollmentApplicationItems/' + item.id, JSON.stringify(item))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findEnrollmentApplications(): Observable<EnrollmentApplication[]> {
    console.log('findEnrollmentApplications');
    return this._http.get(this.TERM_API + '/enrollmentApplications')
      .map((res: Response) => <EnrollmentApplication[]>res.json());
  }

  findEnrollmentApplicationByReferenceNo(referenceNo: string): Observable<EnrollmentApplication> {
    console.log('findEnrollmentApplicationByReferenceNo');
    return this._http.get(this.TERM_API + '/enrollmentApplications/' + referenceNo)
      .map((res: Response) => <EnrollmentApplication>res.json());
  }

  findEnrollmentApplicationItems(application: EnrollmentApplication): Observable<EnrollmentApplicationItem[]> {
    return this._http.get(this.TERM_API + '/enrollmentApplications/' + application.referenceNo + '/enrollmentApplicationItems')
      .map((res: Response) => <EnrollmentApplicationItem[]>res.json());
  }

  deleteEnrollmentApplicationItem(application: EnrollmentApplication, item: EnrollmentApplicationItem) {
    return this._http.delete(this.TERM_API + '/enrollmentApplications/' + application.referenceNo + '/enrollmentApplicationItems/' + item.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeEnrollmentApplication(admission: Admission, application: EnrollmentApplication): Observable<String> {
    return this._http.delete(this.TERM_API + '/admissions/' + admission.id + '/enrollment-applications/' + application.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ENROLLMENT
  // ==================================================================================================== //

  findEnrollments(): Observable<Enrollment[]> {
    console.log('findEnrollments');
    return this._http.get(this.TERM_API + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findCurrentEnrollments(): Observable<Enrollment[]> {
    console.log('findCurrentEnrollments');
    return this._http.get(this.TERM_API + '/enrollments/current')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findEnrollmentById(id: number): Observable<Enrollment[]> {
    console.log('findEnrollmentById');
    return this._http.get(this.TERM_API + '/enrollments/' + id)
      .map((res: Response) => <Enrollment[]>res.json());
  }

  updateEnrollment(section: Section, enrollment: Enrollment): Observable<String> {
    console.log(enrollment);
    return this._http.put(this.TERM_API + '/sections/' + section.canonicalCode + '/enrollments/' + enrollment.id, JSON.stringify(enrollment))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  //==================================================================================================== //
  // GRADEBOOK
  // ==================================================================================================== //

  findGradebookById(id: number): Observable<Gradebook[]> {
      console.log('findGradebookById');
      return this._http.get(this.TERM_API + '/gradebooks/' + id)
        .map((res: Response) => <Gradebook[]>res.json());
    }
  
  // ==================================================================================================== //
  // APPOINTMENT
  // ==================================================================================================== //

  findAppointments(): Observable<Appointment[]> {
    console.log('findAppointments');
    return this._http.get(this.TERM_API + '/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  findCurrentAppointments(): Observable<Appointment[]> {
    console.log('findCurrentAppointments');
    return this._http.get(this.TERM_API + '/appointments/current')
      .map((res: Response) => <Appointment[]>res.json());
  }

  findAppointmentById(id): Observable<Appointment> {
    console.log('findAppointmentById');
    return this._http.get(this.TERM_API + '/appointments/' + id)
      .map((res: Response) => <Appointment>res.json());
  }

  // ==================================================================================================== //
  // SECTION
  // ==================================================================================================== //

  findSections(): Observable<Section[]> {
    console.log('findSections');
    return this._http.get(this.TERM_API + '/sections')
      .map((res: Response) => <Section[]>res.json());
  }

  findSectionByCanonicalCode(canonicalCode): Observable<Section> {
    console.log('findSectionByCanonicalCode');
    return this._http.get(this.TERM_API + '/sections/' + canonicalCode)
      .map((res: Response) => <Section>res.json());
  }

  //find enrollments by section
  findEnrollmentsBySection(section: Section): Observable<Enrollment[]> {
    console.log('findEnrollmentsBySection');
    return this._http.get(this.TERM_API + '/sections/' + section.canonicalCode + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }
  
  //find gradebooks by section
  findGradebooksBySection(section: Section): Observable<Gradebook[]> {
    console.log('findGradebooksBySection');
    return this._http.get(this.TERM_API + '/sections/' + section.canonicalCode + '/gradebooks')
      .map((res: Response) => <Gradebook[]>res.json());
  }

  //find appointments by section
  findAppointmentsBySection(section: Section): Observable<Appointment[]> {
    console.log('findAppointmentsBySection');
    return this._http.get(this.TERM_API + '/sections/' + section.canonicalCode + '/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  // ==================================================================================================== //
  // OFFERING
  // ==================================================================================================== //

  findOfferings(): Observable<Offering[]> {
    console.log('findOfferings');
    return this._http.get(this.TERM_API + '/offerings')
      .map((res: Response) => <Offering[]>res.json());
  }

  findOfferingByCanonicalCode(canonicalCode): Observable<Offering> {
    console.log('findOfferingByCanonicalCode');
    return this._http.get(this.TERM_API + '/offerings/' + canonicalCode)
      .map((res: Response) => <Offering>res.json());
  }

  findSectionsByOffering(offering: Offering): Observable<Section[]> {
    console.log('findSectionsByOffering');
    return this._http.get(this.TERM_API + '/offerings/' + offering.canonicalCode + '/sections')
      .map((res: Response) => <Section[]>res.json());
  }

  findAssessmentsByOffering(offering: Offering): Observable<Assessment[]> {
    console.log('findAssessmentsByOffering');
    return this._http.get(this.TERM_API + '/offerings/' + offering.canonicalCode + '/assessments')
      .map((res: Response) => <Assessment[]>res.json());
  }

  findEnrollmentsByOffering(offering: Offering): Observable<Enrollment[]> {
    console.log('findEnrollmentsByOffering');
    return this._http.get(this.TERM_API + '/offerings/' + offering.canonicalCode + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findAppointmentsByOffering(offering: Offering): Observable<Appointment[]> {
    console.log('findAppointmentsByOffering');
    return this._http.get(this.TERM_API + '/offerings/' + offering.canonicalCode + '/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  findGradebookMatricesByOffering(offering: Offering): Observable<GradebookMatrix[]> {
    console.log('findGradebookMatricesByOffering');
    return this._http.get(this.TERM_API + '/offerings/' + offering.canonicalCode + '/gradebookMatrices')
      .map((res: Response) => <GradebookMatrix[]>res.json());
  }

  saveOffering(program: Program, course: Course, offering: Offering): Observable<String> {
    console.log('saveOffering');
    console.log('offering:' + offering.canonicalCode);
    console.log('program:' + program.code);
    console.log('course:' + course.code);

    console.log('save offering');
    return this._http.post(this.TERM_API + '/offerings', JSON.stringify(offering))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  addSection(offering: Offering, section: Section): Observable<String> {
    console.log('addSection:' + section);
    console.log('offering:' + offering.canonicalCode);
    return this._http.post(this.TERM_API + '/offerings/' + offering.canonicalCode + '/sections', JSON.stringify(section))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteSection(offering: Offering, section: Section) {
    return this._http.delete(this.TERM_API + '/offerings/' + offering.canonicalCode + '/sections/' + section.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateSection(offering: Offering, section: Section): Observable<String> {
    console.log(section);
    return this._http.put(this.TERM_API + '/offerings/' + offering.canonicalCode + '/sections/' + section.id, JSON.stringify(section))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateOffering(offering: Offering): Observable<String> {
    return this._http.put(this.TERM_API + '/offerings/' + offering.canonicalCode, JSON.stringify(offering))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addAppointment(section: Section, appointment: Appointment): Observable<String> {
    console.log('addAppointment');
    console.log(section);
    return this._http.post(this.TERM_API + '/sections/' + section.canonicalCode + '/appointments', JSON.stringify(appointment))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // remove appointment by section
  removeAppointment(section: Section, appointment: Appointment): Observable<String> {
    return this._http.delete(this.TERM_API + '/sections/' + section.canonicalCode + '/appointments/' + appointment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAppointment(section: Section, appointment: Appointment): Observable<String> {
    console.log(appointment);
    return this._http.put(this.TERM_API + '/sections/' + section.canonicalCode + '/appointments/' + appointment.id, JSON.stringify(appointment))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEnrollment(offering: Offering, enrollment: Enrollment): Observable<String> {
    return this._http.delete(this.TERM_API + '/offerings/' + offering.canonicalCode + '/enrollments/' + enrollment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  uploadGradebook(offering: Offering, file: File): Observable<String> {
    console.log('uploadGradebook', file);
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    let formData: FormData = new FormData();
    formData.append('file', file);
    console.log('formData', formData);
    return this.http.post(this.TERM_API + '/offerings/' + offering.canonicalCode + '/uploadGradebook', formData)
      .flatMap((res: Response) => Observable.of(res.text()));

  }

  downloadGradebook(offering: Offering): Observable<File> {
    console.log('downloadGradebook');
    let options = new RequestOptions({responseType: ResponseContentType.ArrayBuffer});
    return this._http.get(this.TERM_API + '/offerings/' + offering.canonicalCode + '/downloadGradebook', options)
      .map((res: Response) => {
        let type = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
        let filename = offering.canonicalCode + '.xlsx';
        return new File([res.arrayBuffer()], filename, {type: type});
      });
  }

  calculateGradebook(offering: Offering): Observable<String> {
    console.log('CalculateTotalScore');
    let options: RequestOptions = new RequestOptions({responseType: ResponseContentType.ArrayBuffer});
    return this._http.post(this.TERM_API + '/offerings/' + offering.canonicalCode + '/calculateGradebook', options)
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
