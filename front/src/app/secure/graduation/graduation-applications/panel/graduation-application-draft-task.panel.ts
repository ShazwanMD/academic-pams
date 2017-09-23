import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {GraduationApplicationTask} from '../../../../shared/model/graduation/graduation-application-task.interface';
import {GraduationApplicationActions} from '../graduation-application.action';
import {Store} from '@ngrx/store';
import {GraduationModuleState} from '../../index';
import {GraduationApplicationEditorDialog} from '../dialog/graduation-application-editor.dialog';
import { GraduationService } from "../../../../../services/graduation.service";

@Component({
  selector: 'pams-graduation-application-draft-task',
  templateUrl: './graduation-application-draft-task.panel.html',
})

export class GraduationApplicationDraftTaskPanel implements OnInit {

    
  @Input() graduationApplicationTask: GraduationApplicationTask;
  private creatorDialogRef: MdDialogRef<GraduationApplicationEditorDialog>;
  private _route: ActivatedRoute;
  private _graduationService: GraduationService;
  private _snackBar: MdSnackBar;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: GraduationApplicationActions,
              private store: Store<GraduationModuleState>,
              graduationService: GraduationService,
              private dialog: MdDialog,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar) {
      
      this._route = route;
      this._graduationService = graduationService;
      this._snackBar = snackBar;
  }

  ngOnInit(): void {
      this._route.params.subscribe((params: { taskId: string }) => {
          let taskId: string = params.taskId;
          // ngrx
        });
  }

  /*register() {
    this.store.dispatch(this.actions.completeGraduationApplicationTask(this.graduationApplicationTask));
    this.goBack();
  }*/
  
  register(): void {
      this._graduationService.completeGraduationApplicationTask(this.graduationApplicationTask).subscribe((res) => {
        let snackBarRef = this._snackBar.open('Graduation application completed', 'OK');
        snackBarRef.afterDismissed().subscribe(() => {
          this.goBack();
        });
      });
    }

  goBack(): void {
    this.router.navigate(['secure/graduation/graduation-applications']);
  }

  showDialog(): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '40%';
    config.position = {top: '65px'};
    this.creatorDialogRef = this.dialog.open(GraduationApplicationEditorDialog, config);
    this.creatorDialogRef.componentInstance.application = this.graduationApplicationTask.application;

    // close
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

}
