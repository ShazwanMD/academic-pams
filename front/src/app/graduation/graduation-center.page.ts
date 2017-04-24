import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Student} from "../identity/student.interface";

@Component({
  selector: 'pams-graduation-center',
  templateUrl: 'graduation-center.page.html',
})

export class GraduationCenterPage implements OnInit {





  constructor(private router: Router,
              private route: ActivatedRoute) {
  }

  goBack(route: string): void {
  }

  viewProfile(student: Student) {
  }

  ngOnInit(): void {
  }
}

