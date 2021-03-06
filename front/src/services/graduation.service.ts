import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';
import { Observable } from 'rxjs/Observable';
import { GraduationApplication } from '../app/shared/model/graduation/graduation-application.interface';
import { environment } from '../environments/environment';
import { GraduationApplicationTask } from '../app/shared/model/graduation/graduation-application-task.interface';
import { Graduation } from "../app/shared/model/graduation/graduation.interface";

@Injectable()
export class GraduationService {

    private GRADUATION_API: string = environment.endpoint + '/api/graduation';

    constructor( private _http: HttpInterceptorService ) {
    }

    // ====================================================================================================
    // GRADUATION APPLICATION
    // ====================================================================================================

    findCompletedGraduationApplications(): Observable<GraduationApplication[]> {
        console.log( 'findCompletedGraduationApplications' );
        return this._http.get( this.GRADUATION_API + '/graduationApplications/state/COMPLETED' )
            .map(( res: Response ) => <GraduationApplication[]>res.json() );
    }

    findAssignedGraduationApplicationTasks(): Observable<GraduationApplicationTask[]> {
        console.log( 'findAssignedGraduationApplicationTasks' );
        return this._http.get( this.GRADUATION_API + '/graduationApplications/assignedTasks' )
            .map(( res: Response ) => <GraduationApplicationTask[]>res.json() );
    }

    //find graduationApplications
    findGraduationApplications(): Observable<GraduationApplication[]> {
        console.log( 'findGraduationApplications' );
        return this._http.get( this.GRADUATION_API + '/graduationApplications' )
            .map(( res: Response ) => <GraduationApplication[]>res.json() );
    }
    
  //find graduations
    findGraduations(): Observable<Graduation[]> {
        console.log( 'findGraduations' );
        return this._http.get( this.GRADUATION_API + '/graduations' )
            .map(( res: Response ) => <Graduation[]>res.json() );
    }

    findPooledGraduationApplicationTasks(): Observable<GraduationApplicationTask[]> {
        console.log( 'findPooledGraduationApplicationTasks' );
        return this._http.get( this.GRADUATION_API + '/graduationApplications/pooledTasks' )
            .map(( res: Response ) => <GraduationApplicationTask[]>res.json() );
    }

    //find archived graduation application
    findArchivedGraduationApplications(): Observable<GraduationApplication[]> {
        console.log( 'findArchivedGraduationApplications' );
        return this._http.get( this.GRADUATION_API + '/graduationApplications/archived' )
            .map(( res: Response ) => <GraduationApplication[]>res.json() );
    }

    findGraduationApplicationTaskByTaskId( taskId: string ): Observable<GraduationApplicationTask> {
        console.log( 'findGraduationApplicationTaskByTaskId' );
        return this._http.get( this.GRADUATION_API + '/graduationApplications/viewTask/' + taskId )
            .map(( res: Response ) => <GraduationApplicationTask>res.json() );
    }

    findGraduationApplicationByReferenceNo( referenceNo: string ): Observable<GraduationApplication> {
        return this._http.get( this.GRADUATION_API + '/graduationApplications/' + referenceNo )
            .map(( res: Response ) => <GraduationApplication>res.json() );
    }

    findGraduationApplicationByTaskId( taskId: string ): Observable<GraduationApplication> {
        return this._http.get( this.GRADUATION_API + '/graduationApplications/' + taskId )
            .map(( res: Response ) => <GraduationApplication>res.json() );
    }

    startGraduationApplicationTask( graduationApplication: GraduationApplication ): Observable<String> {
        return this._http.post( this.GRADUATION_API + '/graduationApplications/startTask', JSON.stringify( graduationApplication ) )
            .flatMap(( res: Response ) => Observable.of( res.text() ) );
    }
    //graduation application by administrator
    completeGraduationApplicationTask( graduationApplicationTask: GraduationApplicationTask ): Observable<String> {
        console.log( 'TaskId: ' + graduationApplicationTask.taskId );
        return this._http.post( this.GRADUATION_API + '/graduationApplications/completeTask', JSON.stringify( graduationApplicationTask ) )
            .flatMap(( res: Response ) => Observable.of( res.text() ) );
    }
    
  //graduation application by student
    studentCompleteGraduationApplicationTask( graduationApplicationTask: GraduationApplicationTask ): Observable<String> {
        console.log( 'Student TaskId: ' + graduationApplicationTask.taskId );
        return this._http.post( this.GRADUATION_API + '/graduationApplications/studentCompleteTask', JSON.stringify( graduationApplicationTask ) )
            .flatMap(( res: Response ) => Observable.of( res.text() ) );
    }
    
    claimGraduationApplicationTask( graduationApplicationTask: GraduationApplicationTask ): Observable<String> {
        return this._http.post( this.GRADUATION_API + '/graduationApplications/claimTask', JSON.stringify( graduationApplicationTask ) )
            .flatMap(( res: Response ) => Observable.of( res.text() ) );
    }

    releaseGraduationApplicationTask( graduationApplicationTask: GraduationApplicationTask ): Observable<String> {
        return this._http.post( this.GRADUATION_API + '/graduationApplications/releaseTask', JSON.stringify( graduationApplicationTask ) )
            .flatMap(( res: Response ) => Observable.of( res.text() ) );
    }

    //updateGraduationApplication(graduationApplication: GraduationApplication): Observable<Boolean> {
    //return Observable.of(true);
    // return this._http.put( this.GRADUATION_API + '/graduationApplications', JSON.stringify( graduationApplication ) )
    // .flatMap( data => Observable.of( true ) );

    updateGraduationApplication( graduationApplication: GraduationApplication ): Observable<String> {
        return this._http.put(this.GRADUATION_API + '/graduationApplications/' + graduationApplication.referenceNo, JSON.stringify(graduationApplication))
        .flatMap((res: Response) => Observable.of(res.text()));
    }
    
    /*//sample to delete
    updateOffering( offering: Offering ): Observable<String> {
        return this._http.put( this.TERM_API + '/offerings/' + offering.canonicalCode, JSON.stringify( offering ) )
            .flatMap(( res: Response ) => Observable.of( res.text() ) );
    }
*/
    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private handleError( error: Response | any ) {
        let body: any = error.json();
        return Observable.throw( body );
    }
}
