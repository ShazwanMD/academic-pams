import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {GraduationApplication} from '../app/graduation/graduation-applications/graduation-application.interface';
import {environment} from '../environments/environment';
import {GraduationApplicationTask} from '../app/graduation/graduation-applications/graduation-application-task.interface';

@Injectable()
export class GraduationService {

  private graduation_api: string = environment.endpoint + '/api/graduation';

  constructor(private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // GRADUATION APPLICATION
  // ====================================================================================================

  findCompletedGraduationApplications(): Observable<GraduationApplication[]> {
    console.log('findCompletedGraduationApplications');
    return this._http.get(this.graduation_api + '/graduationApplications/state/COMPLETED')
      .map((res: Response) => <GraduationApplication[]>res.json());
  }

  findAssignedGraduationApplicationTasks(): Observable<GraduationApplicationTask[]> {
    console.log('findAssignedGraduationApplicationTasks');
    return this._http.get(this.graduation_api + '/graduationApplications/assignedTasks')
      .map((res: Response) => <GraduationApplicationTask[]>res.json());
  }

  findPooledGraduationApplicationTasks(): Observable<GraduationApplicationTask[]> {
    console.log('findPooledGraduationApplicationTasks');
    return this._http.get(this.graduation_api + '/graduationApplications/pooledTasks')
      .map((res: Response) => <GraduationApplicationTask[]>res.json());
  }

  findGraduationApplicationTaskByTaskId(taskId: string): Observable<GraduationApplicationTask> {
    console.log('findGraduationApplicationTaskByTaskId');
    return this._http.get(this.graduation_api + '/graduationApplications/viewTask/' + taskId)
      .map((res: Response) => <GraduationApplicationTask>res.json());
  }

  findGraduationApplicationByReferenceNo(referenceNo: string): Observable<GraduationApplication> {
    return this._http.get(this.graduation_api + '/graduationApplications/' + referenceNo)
      .map((res: Response) => <GraduationApplication>res.json());
  }

  findGraduationApplicationByTaskId(taskId: string): Observable<GraduationApplication> {
    return this._http.get(this.graduation_api + '/graduationApplications/' + taskId)
      .map((res: Response) => <GraduationApplication>res.json());
  }

  startGraduationApplicationTask(graduationApplication: GraduationApplication): Observable<String> {
    return this._http.post(this.graduation_api + '/graduationApplications/startTask', JSON.stringify(graduationApplication))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  completeGraduationApplicationTask(graduationApplicationTask: GraduationApplicationTask): Observable<String> {
    console.log('TaskId: ' + graduationApplicationTask.taskId);
    return this._http.post(this.graduation_api + '/graduationApplications/completeTask', JSON.stringify(graduationApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimGraduationApplicationTask(graduationApplicationTask: GraduationApplicationTask): Observable<String> {
    return this._http.post(this.graduation_api + '/graduationApplications/claimTask', JSON.stringify(graduationApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseGraduationApplicationTask(graduationApplicationTask: GraduationApplicationTask): Observable<String> {
    return this._http.post(this.graduation_api + '/graduationApplications/releaseTask', JSON.stringify(graduationApplicationTask))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGraduationApplication(graduationApplication: GraduationApplication): Observable<Boolean> {
    return Observable.of(true);
    // return this._http.put(this.graduation_api + '/graduationApplications', JSON.stringify(graduationApplication))
    //   .flatMap(data => Observable.of(true));
  }
}
