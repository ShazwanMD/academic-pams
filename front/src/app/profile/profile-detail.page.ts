import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Student} from "../identity/student.interface";
import {ProfileActions} from "./profile.action";
import {ProfileModuleState} from "./index";

@Component({
  selector: 'pams-profile-detail',
  templateUrl: 'profile-detail.page.html',
})

export class ProfileDetailPage implements OnInit {

  private STUDENT = "profileModuleState.student".split(".");
  private student$: Observable<Student>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private store: Store<ProfileModuleState>) {

    this.student$ = this.store.select(...this.STUDENT);
  }

  ngOnInit(): void {
     this.route.params.subscribe((params: {identityNo: string}) => {
       let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findProfile(identityNo));
    });
   }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }
}

