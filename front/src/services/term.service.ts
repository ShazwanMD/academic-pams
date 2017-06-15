import {Course} from './../app/planner/courses/course.interface';
import {Program} from './../app/planner/programs/program.interface';
import {AdmissionApplication} from './../app/term/admission-applications/admission-application.interface';
import {Assessment} from './../app/term/assessments/assessment.interface';
import {Offering} from '../app/term/offerings/offering.interface';
import {Injectable} from '@angular/core';
import {Response, Http, ResponseContentType} from '@angular/http';
import {Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/filter';
import {environment} from "../environments/environment";
import {EnrollmentApplication} from "../app/term/enrollment-applications/enrollment-application.interface";
import {EnrollmentApplicationItem} from "../app/term/enrollment-applications/enrollment-application-item.interface";
import {EnrollmentApplicationTask} from "../app/term/enrollment-applications/enrollment-application-task.interface";
import {Admission} from "../app/term/admissions/admission.interface";
import {Enrollment} from "../app/term/enrollments/enrollment.interface";
import {AdmissionApplicationTask} from "../app/term/admission-applications/admission-application-task.interface";
import {Appointment} from "../app/term/appointments/appointment.interface";
import {Section} from "../app/term/sections/section.interface";
import {GradebookMatrix} from "../app/term/offerings/gradebook-matrix.interface";

@Injectable()
export class TermService {

  constructor(private _http: HttpInterceptorService,
              private http: Http) {
  }

  findAssessmentById(id): Observable<Assessment> {
    console.log("findAssessmentById");
    return this.http.get(environment.endpoint + '/api/term/assessments/' + id)
      .map((res: Response) => <Assessment>res.json());
  }


  findAssessments(): Observable<Assessment[]> {
    console.log("findAssessments");
    return this.http.get(environment.endpoint + '/api/term/assessments')
      .map((res: Response) => <Assessment[]>res.json());
  }


  addAssessment(offering: Offering, assessment: Assessment): Observable<String> {
    console.log("addAssessment:" + assessment);
    console.log("offering:" + offering.canonicalCode);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/assessments', JSON.stringify(assessment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAssessment(offering: Offering, assessment: Assessment): Observable<String> {
    console.log(assessment);
    console.log("addOffering:" + offering.canonicalCode);
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/assessments/' + assessment.id, JSON.stringify(assessment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAssessment(offering: Offering, assessment: Assessment) {
    let headers = new Headers({
      'Content-Type': 'application/json',
    });
    let options = new RequestOptions({headers: headers});
    console.log("deleteAssessmentInService")
    return this.http.delete(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/assessments/' + assessment.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ADMISSION APPLICATION
  // ==================================================================================================== //

  findAdmissionApplications(): Observable<AdmissionApplication[]> {
    console.log("findAdmissionApplication");
    return this.http.get(environment.endpoint + '/api/term/admissionApplications/')
      .map((res: Response) => <AdmissionApplication[]>res.json());

  }

  findAssignedAdmissionApplicationTasks(): Observable<AdmissionApplicationTask[]> {
    console.log("findAssignedAdmissionApplicationTasks");
    return this.http.get(environment.endpoint + '/api/term/admissionApplications/assignedTasks')
      .map((res: Response) => <AdmissionApplicationTask[]>res.json());
  }

  findPooledAdmissionApplicationTasks(): Observable<AdmissionApplicationTask[]> {
    console.log("findPooledAdmissionApplicationTasks");
    return this.http.get(environment.endpoint + '/api/term/admissionApplications/pooledTasks')
      .map((res: Response) => <AdmissionApplicationTask[]>res.json());
  }

  findAdmissionApplicationTaskByTaskId(taskId: string): Observable<AdmissionApplicationTask> {
    console.log("findAdmissionApplicationTaskByTaskId");
    return this.http.get(environment.endpoint + '/api/term/admissionApplications/viewTask/' + taskId)
      .map((res: Response) => <AdmissionApplicationTask>res.json());
  }

  findAdmissionApplicationByTaskId(taskId: string): Observable<AdmissionApplication> {
    return this.http.get(environment.endpoint + '/api/term/admissionApplications/' + taskId)
      .map((res: Response) => <AdmissionApplication>res.json());
  }

  startAdmissionApplicationTask(admissionApplication: AdmissionApplication): Observable<String> {
    console.log("start task");
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/admissionApplications/startTask', JSON.stringify(admissionApplication), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAdmissionApplication(admissionApplication: AdmissionApplication): Observable<String> {
    return this.http.put(environment.endpoint + '/api/term/admissionApplications', JSON.stringify(admissionApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  saveAdmissionApplication(admissionApplication: AdmissionApplication): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/admissionApplications' + '/save', JSON.stringify(admissionApplication), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findAdmissionApplicationByReferenceNo(referenceNo: string): Observable<AdmissionApplication> {
    return this.http.get(environment.endpoint + '/api/term/admissionApplications/' + referenceNo)
      .map((res: Response) => <AdmissionApplication>res.json());
  }

  completeAdmissionApplicationTask(admissionApplicationTask: AdmissionApplicationTask): Observable<String> {
    console.log("TaskId: " + admissionApplicationTask.taskId);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/admissionApplications/completeTask', JSON.stringify(admissionApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimAdmissionApplicationTask(admissionApplicationTask: AdmissionApplicationTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/admissionApplications/claimTask', JSON.stringify(admissionApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseAdmissionApplicationTask(admissionApplicationTask: AdmissionApplicationTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/admissionApplications/releaseTask', JSON.stringify(admissionApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ADMISSION
  // ==================================================================================================== //

  findAdmissions(): Observable<Admission[]> {
    console.log("findAdmissions");
    return this.http.get(environment.endpoint + '/api/term/admissions')
      .map((res: Response) => <Admission[]>res.json());
  }

  findCurrentAdmissions(): Observable<Admission[]> {
    console.log("findCurrentAdmissions");
    return this.http.get(environment.endpoint + '/api/term/admissions/current')
      .map((res: Response) => <Admission[]>res.json());
  }

  findAdmissionById(id): Observable<Admission> {
    console.log("findAdmissionById");
    return this.http.get(environment.endpoint + '/api/term/admissions/' + id)
      .map((res: Response) => <Admission>res.json());
  }

  //find enrollments by admission created on 14/6/2017
  findEnrollmentsByAdmission(admission: Admission): Observable<Enrollment[]> {
      console.log("findEnrollmentsByAdmission");
      return this.http.get(environment.endpoint + '/api/term/admissions/' + admission.id + '/enrollments')
        .map((res: Response) => <Enrollment[]>res.json());
    }

  saveAdmission(admission: Admission): Observable<String> {
    console.log("saveAdmission");
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/admissions', JSON.stringify(admission), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAdmission(admission: Admission): Observable<String> {
    console.log("updateAdmission");
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/term/admissions/', JSON.stringify(admission), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ==================================================================================================== //
  // ENROLLMENT APPLICATION
  // ==================================================================================================== //

  findAssignedEnrollmentApplicationTasks(): Observable<EnrollmentApplicationTask[]> {
    console.log("findAssignedEnrollmentApplicationTasks");
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications/assignedTasks')
      .map((res: Response) => <EnrollmentApplicationTask[]>res.json());
  }

  findPooledEnrollmentApplicationTasks(): Observable<EnrollmentApplicationTask[]> {
    console.log("findPooledEnrollmentApplicationTasks");
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications/pooledTasks')
      .map((res: Response) => <EnrollmentApplicationTask[]>res.json());
  }

  findEnrollmentApplicationTaskByTaskId(taskId: string): Observable<EnrollmentApplicationTask> {
    console.log("findEnrollmentApplicationTaskByTaskId");
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications/viewTask/' + taskId)
      .map((res: Response) => <EnrollmentApplicationTask>res.json());
  }

  findEnrollmentApplicationByTaskId(taskId: string): Observable<EnrollmentApplication> {
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications/' + taskId)
      .map((res: Response) => <EnrollmentApplication>res.json());
  }

  startEnrollmentApplicationTask(enrollmentApplication: EnrollmentApplication): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    console.log("proses startEnrollmentApplicationTask");
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/startTask', JSON.stringify(enrollmentApplication), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  completeEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
    console.log("TaskId: " + enrollmentApplicationTask.taskId);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/completeTask', JSON.stringify(enrollmentApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/claimTask', JSON.stringify(enrollmentApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/releaseTask', JSON.stringify(enrollmentApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateEnrollmentApplication(enrollmentApplication: EnrollmentApplication): Observable<String> {
    return this.http.put(environment.endpoint + '/api/term/enrollmentApplications', JSON.stringify(enrollmentApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addEnrollmentApplicationItem(enrollmentApplication: EnrollmentApplication, item: EnrollmentApplicationItem): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/' + enrollmentApplication.referenceNo + '/enrollmentApplicationItems', JSON.stringify(item), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findEnrollmentApplications(): Observable<EnrollmentApplication[]> {
    console.log("findEnrollmentApplications");
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications')
      .map((res: Response) => <EnrollmentApplication[]>res.json());
  }

  findEnrollmentApplicationByReferenceNo(referenceNo: string): Observable<EnrollmentApplication> {
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications/' + referenceNo)
      .map((res: Response) => <EnrollmentApplication>res.json());
  }

  findEnrollmentApplicationItems(application: EnrollmentApplication): Observable<EnrollmentApplicationItem[]> {
    var endpoint = environment.endpoint + '/api/term/enrollmentApplications/' + application.referenceNo + '/enrollmentApplicationItems'
    return this.http.get(endpoint)
      .map((res: Response) => <EnrollmentApplicationItem[]>res.json());
  }

  deleteEnrollmentApplicationItem(application: EnrollmentApplication, item: EnrollmentApplicationItem) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/term/enrollmentApplications/' + application.referenceNo + '/enrollmentApplicationItems/' + item.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // ENROLLMENT
  // ==================================================================================================== //

  findEnrollments(): Observable<Enrollment[]> {
    console.log("findEnrollments");
    return this.http.get(environment.endpoint + '/api/term/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findCurrentEnrollments(): Observable<Enrollment[]> {
    console.log("findCurrentEnrollments");
    return this.http.get(environment.endpoint + '/api/term/enrollments/current')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findEnrollmentById(id: number): Observable<Enrollment[]> {
    console.log("findEnrollmentById");
    return this.http.get(environment.endpoint + '/api/term/enrollments/' + id)
      .map((res: Response) => <Enrollment[]>res.json());
  }

  //update enrollment by section
  //update appointment by section
  updateEnrollment(section: Section, enrollment: Enrollment): Observable<String> {
    console.log(enrollment);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/term/sections/' + section.canonicalCode + '/enrollments/' + enrollment.id, JSON.stringify(enrollment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ==================================================================================================== //
  // APPOINTMENT
  // ==================================================================================================== //

  findAppointments(): Observable<Appointment[]> {
    console.log("findAppointments");
    return this.http.get(environment.endpoint + '/api/term/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  findCurrentAppointments(): Observable<Appointment[]> {
    console.log("findCurrentAppointments");
    return this.http.get(environment.endpoint + '/api/term/appointments/current')
      .map((res: Response) => <Appointment[]>res.json());
  }

  findAppointmentById(id): Observable<Appointment> {
    console.log("findAppointmentById");
    return this.http.get(environment.endpoint + '/api/term/appointments/' + id)
      .map((res: Response) => <Appointment>res.json());
  }

  // ==================================================================================================== //
  // SECTION
  // ==================================================================================================== //

  findSections(): Observable<Section[]> {
    console.log("findSections");
    return this.http.get(environment.endpoint + '/api/term/sections')
      .map((res: Response) => <Section[]>res.json());
  }

  findSectionByCanonicalCode(canonicalCode): Observable<Section> {
    console.log("findSectionByCanonicalCode");
    return this.http.get(environment.endpoint + '/api/term/sections/' + canonicalCode)
      .map((res: Response) => <Section>res.json());
  }

  //find enrollments by section
  findEnrollmentsBySection(section: Section): Observable<Enrollment[]> {
    console.log("findEnrollmentsBySection");
    return this.http.get(environment.endpoint + '/api/term/sections/' + section.canonicalCode + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  //find appointments by section
  findAppointmentsBySection(section: Section): Observable<Appointment[]> {
    console.log("findAppointmentsBySection");
    return this.http.get(environment.endpoint + '/api/term/sections/' + section.canonicalCode + '/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  // ==================================================================================================== //
  // OFFERING
  // ==================================================================================================== //

  findOfferings(): Observable<Offering[]> {
    console.log("findOfferings");
    return this.http.get(environment.endpoint + '/api/term/offerings')
      .map((res: Response) => <Offering[]>res.json());
  }

  findOfferingByCanonicalCode(canonicalCode): Observable<Offering> {
    console.log("findOfferingByCanonicalCode");
    return this.http.get(environment.endpoint + '/api/term/offerings/' + canonicalCode)
      .map((res: Response) => <Offering>res.json());
  }

  findSectionsByOffering(offering: Offering): Observable<Section[]> {
    console.log("findSectionsByOffering");
    return this.http.get(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/sections')
      .map((res: Response) => <Section[]>res.json());
  }

  findAssessmentsByOffering(offering: Offering): Observable<Assessment[]> {
    console.log("findAssessmentsByOffering");
    return this.http.get(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/assessments')
      .map((res: Response) => <Assessment[]>res.json());
  }

  findEnrollmentsByOffering(offering: Offering): Observable<Enrollment[]> {
    console.log("findEnrollmentsByOffering");
    return this.http.get(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/enrollments')
      .map((res: Response) => <Enrollment[]>res.json());
  }

  findAppointmentsByOffering(offering: Offering): Observable<Appointment[]> {
    console.log("findAppointmentsByOffering");
    return this.http.get(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/appointments')
      .map((res: Response) => <Appointment[]>res.json());
  }

  findGradebookMatricesByOffering(offering: Offering): Observable<GradebookMatrix[]> {
    console.log("findGradebookMatricesByOffering");
    return this.http.get(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/gradebookMatrices')
      .map((res: Response) => <GradebookMatrix[]>res.json());
  }

  //save offering
  saveOffering(program: Program, course: Course, offering: Offering): Observable<String> {
    console.log("saveOffering");
    console.log("offering:" + offering.canonicalCode);
    console.log("program:" + program.code);
    console.log("course:" + course.code);

    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    console.log("save offering");
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/offerings', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  //add new section
  addSection(offering: Offering, section: Section): Observable<String> {
    console.log("addSection:" + section);
    console.log("offering:" + offering.canonicalCode);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/sections', JSON.stringify(section), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  //delete Section using editorDialog
  deleteSection(offering: Offering, section: Section) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/sections/' + section.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // update Section using dialog
  updateSection(offering: Offering, section: Section): Observable<String> {
    console.log(section);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/sections/' + section.id, JSON.stringify(section), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  //update offering using editorDialog
  updateOffering(offering: Offering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode, JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // save appointment
  addAppointment(section: Section, appointment: Appointment): Observable<String> {
    console.log("addAppointment");
    console.log(section);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/term/sections/' + section.canonicalCode + '/appointments', JSON.stringify(appointment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // remove appointment by section
  removeAppointment(section: Section, appointment: Appointment) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/term/sections/' + section.canonicalCode + '/appointments/' + appointment.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  //update appointment by section
  updateAppointment(section: Section, appointment: Appointment): Observable<String> {
    console.log(appointment);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/term/sections/' + section.canonicalCode + '/appointments/' + appointment.id, JSON.stringify(appointment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEnrollment(offering: Offering, enrollment: Enrollment) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/enrollments/' + enrollment.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  uploadGradebook(offering: Offering, file: File): Observable<String> {
    console.log('uploadGradebook');
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let formData = new FormData();
    formData.append("file", file);
    return this.http.post(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/uploadGradebook', formData)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  downloadGradebook(offering: Offering): Observable<Blob> {
    console.log('downloadGradebook');
    let options = new RequestOptions({responseType: ResponseContentType.ArrayBuffer});
    return this.http.get(environment.endpoint + '/api/term/offerings/' + offering.canonicalCode + '/downloadGradebook', options)
      .map((res: Response) => new Blob([res.arrayBuffer()], {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'}));
  }
}
