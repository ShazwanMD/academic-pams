import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {Course} from '../../../../shared/model/planner/course.interface';
import {CourseEditorDialog} from '../dialog/course-editor.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {CourseActions} from '../course.action';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';

@Component({
  selector: 'pams-course-action',
  templateUrl: './course-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseActionComponent {

  private editorDialogRef: MdDialogRef<CourseEditorDialog>;
  @Input() course: Course;

  constructor(private actions: CourseActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  editorDialog(): void {
    console.log('edit');
    console.log(this.course);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(CourseEditorDialog, config);
    this.editorDialogRef.componentInstance.course = this.course;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  // deleteCourse(course:Course): void {
  //   this.store.dispatch(this.actions.deleteCourse(this._Course))
  // }

  deactivate(): void {
    let snackBarRef = this.snackBar.open('Deactivating Course', 'OK');
    snackBarRef.afterDismissed().subscribe(() => this.store.dispatch(this.actions.deactivateCourse(this.course)));
  }

  activate(): void {
    let snackBarRef = this.snackBar.open('Activating Course', 'OK');
    snackBarRef.afterDismissed().subscribe(() => this.store.dispatch(this.actions.activateCourse(this.course)));
  }
}
