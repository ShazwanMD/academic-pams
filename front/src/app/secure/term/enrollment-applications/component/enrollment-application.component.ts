import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef} from '@angular/core';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {AppointmentEditorDialog} from '../../appointments/dialog/appointment-editor.dialog';

@Component({
  selector: 'pams-enrollment-application',
  templateUrl: './enrollment-application.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class EnrollmentApplicationComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];
  private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<EnrollmentApplication>();
  @Output() view2 = new EventEmitter<Enrollment>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

}
