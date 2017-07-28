import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef} from '@angular/core';
import {MdDialog} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {IdentityModuleState} from '../../index';
import {Staff} from '../../../../shared/model/identity/staff.interface';

@Component({
  selector: 'pams-staff',
  templateUrl: './staff.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StaffComponent {
  private imgFileName: string = '01001A.jpg';
  @Input() imgPath: string = './../assets/ico/lecturer/';
  @Input() staff: Staff;
  @Output() view = new EventEmitter<Staff>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<IdentityModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

}
