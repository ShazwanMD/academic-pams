import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';

@Component({
  selector: 'pams-item',
  templateUrl: './item.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class ItemComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];
 
  @Input() enrollmentApplicationItem: EnrollmentApplicationItem;
  @Output() view = new EventEmitter<EnrollmentApplicationItem>();
 /* @Input() section: Section;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<EnrollmentApplicationItem>();
  @Output() view2 = new EventEmitter<Enrollment>();
  */

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }
}
