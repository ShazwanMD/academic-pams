import {Injectable} from '@angular/core';
import {MdSnackBar, MdSnackBarConfig} from '@angular/material';
import {ApplicationError} from '../app/core/application-error.interface';
import {Observable} from 'rxjs/Observable';
import { Router } from "@angular/router";

@Injectable()
export class NotificationService {

  constructor(private snackBar: MdSnackBar,
              private router: Router) {
  }
  
  showInfo(message: string) {
    let config = new MdSnackBarConfig();
    config.duration = 5000;
    this.snackBar.open(message, undefined, config);
       
  }

  showError(error: ApplicationError): Observable<any> {
    /*let config: MdSnackBarConfig = new MdSnackBarConfig();
    config.duration = 5000;
     this.snackBar.open(error.error, undefined, config);*/
    //let snackBarRef = this.snackBar.open('Sorry, duplicate data.Please insert new offering data.', 'OK', {duration:5000});    
    
    console.log('error.error',error.error);
    let snackBarRef = this.snackBar.open(error.error, '', {duration:5000});
    console.log('error.error',error.error);
    snackBarRef.afterDismissed().subscribe(() => {
        console.log('The snack-bar was dismissed');
        
       // window.location.reload();
      });
    
    return Observable.of();
    
  }
}
