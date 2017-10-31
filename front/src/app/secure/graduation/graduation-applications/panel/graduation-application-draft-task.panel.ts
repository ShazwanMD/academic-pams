import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {GraduationApplicationTask} from '../../../../shared/model/graduation/graduation-application-task.interface';
import {GraduationApplicationActions} from '../graduation-application.action';
import {Store} from '@ngrx/store';
import {GraduationModuleState} from '../../index';
import {GraduationApplicationEditorDialog} from '../dialog/graduation-application-editor.dialog';
import { GraduationService } from "../../../../../services/graduation.service";
import {GraduationApplication} from '../../../../shared/model/term/graduation-application.interface';

@Component({
  selector: 'pams-graduation-application-draft-task',
  templateUrl: './graduation-application-draft-task.panel.html',
})

export class GraduationApplicationDraftTaskPanel implements OnInit {
   
  //@Input() graduationApplicationTask: GraduationApplicationTask;
  @Input() graduationApplication: GraduationApplication;
  
  
  
  private editorDialogRef: MdDialogRef<GraduationApplicationEditorDialog>;
  private _route: ActivatedRoute;
  private _graduationService: GraduationService;
  private _viewContainerRef: ViewContainerRef;
  private _snackBar: MdSnackBar;
  private _dialog: MdDialog;
  private graduationApplicationTask: GraduationApplicationTask = <GraduationApplicationTask>{};

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
      this._viewContainerRef = viewContainerRef;
      this._dialog = dialog;
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
          console.log(this.graduationApplicationTask);
          let snackBarRef = this._snackBar.open('Graduation application completed', 'OK');
        snackBarRef.afterDismissed().subscribe(() => {
          this.goBack();
        });
      });
    }
  
 
  goBack(): void {
    this.router.navigate(['secure/graduation/graduation-applications']);
  }

   
  remove() {
      this.store.dispatch(this.actions.releaseGraduationApplicationTask(this.graduationApplicationTask));
      this.goBack();
    }
  
  
  showDialog(): void {
      console.log('open graduation app update dialog');
      console.log(this.graduationApplicationTask.id);
      let config = new MdDialogConfig();
      config.viewContainerRef = this._viewContainerRef;
      config.role = 'dialog';
      config.width = '60%';
      config.height = '50%';
      config.position = {top: '0px'};
      this.editorDialogRef = this._dialog.open(GraduationApplicationEditorDialog, config);
      this.editorDialogRef.componentInstance.graduationApplication = this.graduationApplicationTask.application;
    }

}
