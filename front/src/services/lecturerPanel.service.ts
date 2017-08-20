import { Observable } from 'rxjs';
import { Staff } from './../app/shared/model/identity/staff.interface';
import { HttpInterceptorService } from '@covalent/http';
import { Http, Response } from '@angular/http';
import { environment } from './../environments/environment';
import { Injectable } from '@angular/core';
@Injectable()
export class LecturerPanelService {
    private LECTURER_API: string = environment.endpoint + '/api/lecturer';

    constructor(private http: Http, private _http: HttpInterceptorService) {

    }

    // ====================================================================================================
    // LECTURER - LOGIN
    // ====================================================================================================


    findLecturerByUser(): Observable<Staff> {
        return this._http.get(this.LECTURER_API + '/lecturerLogin')
        .map((res: Response) => <Staff>res.json());
        }
}