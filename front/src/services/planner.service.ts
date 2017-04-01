import {Injectable} from '@angular/core';
import {Response, Http, RequestOptions, Headers} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {Program} from "../app/planner/programs/program.interface";
import {Faculty} from "../app/planner/faculties/faculty.interface";
import {Course} from "../app/planner/courses/course.interface";

@Injectable()
export class PlannerService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  findFaculties(): Observable<Faculty[]> {
    console.log("findFaculties");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/faculties', options)
      .map(res => {return <Faculty[]>res.json();})
  }

  findFacultyByCode(code: string): Observable<Faculty> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/faculties/' + code, options)
      .map((res: Response) =><Faculty>res.json());
  }

  findPrograms(): Observable<Program[]> {
    console.log("findPrograms");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programs', options)
      .map((res: Response) => <Program[]>res.json());
  }

  findProgramByCode(code: string): Observable<Program> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programs/' + code, options)
      .map((res: Response) => {
        return <Program>res.json();
      });
  }

  findCourses(): Observable<Course[]> {
    console.log("findCourses");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/courses', options)
      .map((res: Response) => <Course[]>res.json());
  }

  findCourseByCode(code: string): Observable<Course> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/payable/invoices?offset=&limit=', options)
      .map((res: Response) => <Course>res.json());
  }
}
