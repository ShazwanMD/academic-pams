import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs/Observable";
import {GraduationApplication} from "../app/graduation/graduation-applications/graduation-application.interface";
import {environment} from "../environments/environment";
import {GraduationApplicationTask} from "../app/graduation/graduation-applications/graduation-application-task.interface";

@Injectable()
export class GraduationService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // GRADUATION APPLICATION
  // ====================================================================================================

  findCompletedGraduationApplications(): Observable<GraduationApplication[]> {
    console.log("findCompletedGraduationApplications");
    return this.http.get(environment.endpoint + '/api/graduation/graduationApplications/state/COMPLETED')
      .map((res: Response) => <GraduationApplication[]>res.json());
  }

  findAssignedGraduationApplicationTasks(): Observable<GraduationApplicationTask[]> {
    console.log("findAssignedGraduationApplicationTasks");
    return this.http.get(environment.endpoint + '/api/graduation/graduationApplications/assignedTasks')
      .map((res: Response) => <GraduationApplicationTask[]>res.json());
  }

  findPooledGraduationApplicationTasks(): Observable<GraduationApplicationTask[]> {
    console.log("findPooledGraduationApplicationTasks");
    return this.http.get(environment.endpoint + '/api/graduation/graduationApplications/pooledTasks')
      .map((res: Response) => <GraduationApplicationTask[]>res.json());
  }

  findGraduationApplicationTaskByTaskId(taskId: string): Observable<GraduationApplicationTask> {
    console.log("findGraduationApplicationTaskByTaskId");
    return this.http.get(environment.endpoint + '/api/graduation/graduationApplications/viewTask/' + taskId)
      .map((res: Response) => <GraduationApplicationTask>res.json());
  }

  findGraduationApplicationByReferenceNo(referenceNo: string): Observable<GraduationApplication> {
    return this.http.get(environment.endpoint + '/api/graduation/graduationApplications/' + referenceNo)
      .map((res: Response) => <GraduationApplication>res.json());
  }

  findGraduationApplicationByTaskId(taskId: string): Observable<GraduationApplication> {
    return this.http.get(environment.endpoint + '/api/graduation/graduationApplications/' + taskId)
      .map((res: Response) => <GraduationApplication>res.json());
  }

  startGraduationApplicationTask(graduationApplication: GraduationApplication): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/graduation/graduationApplications/startTask', JSON.stringify(graduationApplication), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  completeGraduationApplicationTask(graduationApplicationTask: GraduationApplicationTask): Observable<String> {
    console.log("TaskId: " + graduationApplicationTask.taskId);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/graduation/graduationApplications/completeTask', JSON.stringify(graduationApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimGraduationApplicationTask(graduationApplicationTask: GraduationApplicationTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/graduation/graduationApplications/claimTask', JSON.stringify(graduationApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseGraduationApplicationTask(graduationApplicationTask: GraduationApplicationTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/graduation/graduationApplications/releaseTask', JSON.stringify(graduationApplicationTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGraduationApplication(graduationApplication: GraduationApplication): Observable<Boolean> {
    return Observable.of(true);
    // return this.http.put(environment.endpoint + '/api/graduation/graduationApplications', JSON.stringify(graduationApplication))
    //   .flatMap(data => Observable.of(true));
  }
}
