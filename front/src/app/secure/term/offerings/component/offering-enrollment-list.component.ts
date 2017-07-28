import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef} from '@angular/core';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialog, MdDialogRef} from '@angular/material';
import {AppointmentEditorDialog} from '../../appointments/dialog/appointment-editor.dialog';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-offering-enrollment-list',
  templateUrl: './offering-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingEnrollmentListComponent {

  private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'admission.student.name', label: 'Student'},
    {name: 'admission.student.email', label: 'Email'},
    {name: 'enrollmentStatus', label: 'Status'},
    {name: 'enrollmentStanding', label: 'Standing'},
    {name: 'action', label: ''},
  ];
  @Input() offering: Offering;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Enrollment>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }
}

