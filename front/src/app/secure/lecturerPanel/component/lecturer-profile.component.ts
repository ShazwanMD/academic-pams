import { LecturerActions } from './../lecturer.action';
import { LecturerModuleState } from './../index';
import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef, OnInit } from '@angular/core';
import { MdDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Staff } from "../../../shared/model/identity/staff.interface";

@Component({
  selector: 'pams-lecturer-profile',
  templateUrl: 'lecturer-profile.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LecturerProfileComponent implements OnInit {

@Input() lecturer:Staff;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: LecturerActions,
    private store: Store<LecturerModuleState>,
    private vcf: ViewContainerRef,
    private dialog: MdDialog) {
  }

  ngOnInit(): void {
   
  }

}
