import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {TermService} from '../../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Section} from '../../../shared/model/term/section.interface';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';
import {Appointment} from '../../../shared/model/term/appointment.interface';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {Offering} from '../../../shared/model/term/offering.interface';
import { EnrollmentApplicationItem } from "../../../shared/model/term/enrollment-application-item.interface";
import { EnrollmentApplicationActions } from "./enrollment-application.action";

@Component({
  selector: 'pams-item-detail',
  templateUrl: './item-detail.page.html',
})

export class ItemDetailPage implements OnInit {
 
 
  private ENROLLMENT_APPLICATION_ITEM: string[] = 'termModuleState.enrollmentApplication'.split('.');
  private enrollmentApplicationItem$: Observable<EnrollmentApplicationItem>;

 
  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

   this.enrollmentApplicationItem$ = this.store.select(...this.ENROLLMENT_APPLICATION_ITEM);
  }

  showDialog(): void {
  }

  showDialogDel(): void {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: string }) => {
      let id: string = params.id;
      this.store.dispatch(this.actions.findEnrollmentApplicationItemById(id));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }
}
