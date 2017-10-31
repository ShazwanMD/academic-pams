import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {GraduationApplicationActions} from '../graduation-application.action';
import {Store} from '@ngrx/store';
import {GraduationModuleState} from '../../index';
import {GraduationApplicationTask} from '../../../../shared/model/graduation/graduation-application-task.interface';
import { GraduationApplicationEditorDialog } from "../dialog/graduation-application-editor.dialog";
import { GraduationService } from "../../../../../services/graduation.service";

@Component({
  selector: 'pams-graduation-application-register-task',
  templateUrl: './graduation-application-register-task.panel.html',
})

export class GraduationApplicationRegisterTaskPanel implements OnInit {

  @Input() graduationApplicationTask: GraduationApplicationTask;
  private creatorDialogRef: MdDialogRef<GraduationApplicationEditorDialog>;
  private _route: ActivatedRoute;
  private _graduationService: GraduationService;
  private _snackBar: MdSnackBar;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: GraduationApplicationActions,
              graduationService: GraduationService,
              private store: Store<GraduationModuleState>,
              private dialog: MdDialog,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar) {
      
      this._route = route;
      this._graduationService = graduationService;
      this._snackBar = snackBar;
  }

  ngOnInit(): void {
  }

 /* register() {
    this.store.dispatch(this.actions.completeGraduationApplicationTask(this.graduationApplicationTask));
    this.goBack();
  }
  */
  
  register(): void {
      this._graduationService.completeGraduationApplicationTask(this.graduationApplicationTask).subscribe((res) => {
          console.log(this.graduationApplicationTask);
          let snackBarRef = this._snackBar.open('Graduation application completed', 'OK');
        snackBarRef.afterDismissed().subscribe(() => {
          this.goBack();
        });
      });
    }
  

  goBack(): void {
    this.router.navigate(['/secure/graduation/graduation-applications']);
  }
  
  
  
  remove() {
      this.store.dispatch(this.actions.releaseGraduationApplicationTask(this.graduationApplicationTask));
      this.goBack();
    }
  
}
