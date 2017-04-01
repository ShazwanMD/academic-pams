import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import {Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {EnrollmentApplication} from "../app/term/enrollment-applications/enrollment-application.interface";
import {EnrollmentApplicationItem} from "../app/term/enrollment-applications/enrollment-application-item.interface";
import {EnrollmentApplicationTask} from "../app/term/enrollment-applications/enrollment-application-task.interface";

@Injectable()
export class TermService {

  constructor(private _http: HttpInterceptorService,
              private http: Http) {
  }

  // ==================================================================================================== //
  // EnrollmentApplication
  // ==================================================================================================== //

  findEnrollmentApplications(): Observable<EnrollmentApplication[]> {
    console.log("findEnrollmentApplications");
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications')
      .map((res: Response) => <EnrollmentApplication[]>res.json());
  }

  findEnrollmentApplicationByReferenceNo(referenceNo: string): Observable<EnrollmentApplication> {
    return this.http.get(environment.endpoint + '/api/term/enrollmentApplications/' + referenceNo)
      .map((res: Response) => <EnrollmentApplication>res.json());
  }

  findEnrollmentApplicationItems(enrollmentApplication: EnrollmentApplication): Observable<EnrollmentApplicationItem[]> {
    var endpoint = environment.endpoint + '/api/term/enrollmentApplications/' + enrollmentApplication.referenceNo + '/items'
    return this.http.get(endpoint)
      .map((res:Response) => <EnrollmentApplicationItem[]>res.json());
  }

  startEnrollmentApplicationTask(enrollmentApplication: EnrollmentApplication): Observable<Boolean> {
    return this.http.post(
      environment.endpoint + '/api/term/enrollmentApplications',
      JSON.stringify(enrollmentApplication))
      .flatMap(data => Observable.of(true));
  }

  updateEnrollmentApplication(enrollmentApplication: EnrollmentApplication): Observable<Boolean> {
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/' + enrollmentApplication.referenceNo,
      JSON.stringify(enrollmentApplication))
      .flatMap(data => Observable.of(true));
  }

  completeEnrollmentApplication(enrollmentApplication: EnrollmentApplication): Observable<Boolean> {
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/' + enrollmentApplication.referenceNo + '/complete', JSON.stringify(''))
      .flatMap(data => Observable.of(true));
  }

  addEnrollmentApplicationItem(enrollmentApplication: EnrollmentApplication, item: EnrollmentApplicationItem): Observable<Boolean> {
    return this.http.post(environment.endpoint + '/api/term/enrollmentApplications/' + enrollmentApplication.referenceNo + '/enrollmentApplicationItems', JSON.stringify(item))
      .flatMap(data => Observable.of(true));
  }

  findEnrollmentApplicationTaskByTaskId(taskId: string): Observable<EnrollmentApplicationTask> {
    return null; // todo;
  }

  findEnrollmentApplicationEntries(referenceNo: string): Observable<EnrollmentApplicationItem[]> {
    return null;  // todo
  }

  completeEnrollmentApplicationTask(enrollmentApplicationTask: EnrollmentApplicationTask): Observable<Boolean> {
    return null; // todo
  }
}
