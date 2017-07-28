import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {EnrollmentApplicationItemEditorDialog} from '../dialog/enrollment-application-item-editor.dialog';

@Component({
  selector: 'pams-student-enrollment-application-list',
  templateUrl: './student-enrollment-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class StudentEnrollmentApplicationListComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];
  private creatorDialogRef: MdDialogRef<EnrollmentApplicationItemEditorDialog>;

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
  @Output() view = new EventEmitter<EnrollmentApplication>();
  @Output() view2 = new EventEmitter<EnrollmentApplicationItem>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }
}
