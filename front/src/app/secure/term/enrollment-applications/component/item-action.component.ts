import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef} from '@angular/core';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-item-action',
  templateUrl: './item-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ItemActionComponent {

  
    @Input() enrollmentApplicationItem: EnrollmentApplicationItem;
    @Output() view = new EventEmitter<EnrollmentApplicationItem>();
  
  constructor(private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }
}
