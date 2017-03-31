import {Injectable} from '@angular/core';
import {Response, Http, RequestOptions, Headers} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {Program} from "../app/planner/programs/program.interface";
import {Faculty} from "../app/planner/faculties/faculty.interface";

@Injectable()
export class PlannerService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  findPrograms(): Observable<Program[]> {
    console.log("findPrograms");
    let headers = new Headers({'Authorization': 'Bearer TODO' });
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programs', options)
      .map((res: Response) => {
        return <Program[]>res.json();
      });
  }

  findProgramByCode(code: string): Observable<Program> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programs/' + code, options)
      .map((res: Response) => {
        return <Program>res.json();
      });
  }

  findFaculties(): Observable<Faculty[]> {
    console.log("findFaculties");
    let headers = new Headers({'Authorization': 'Bearer TODO' });
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/faculties', options)
      .map((res: Response) => {
        return <Faculty[]>res.json();
      });
  }

  findFacultyByCode(code: string): Observable<Faculty> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/faculties/' + code, options)
      .map((res: Response) => {
        return <Faculty>res.json();
      });
  }

}
