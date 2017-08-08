import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-student-dashboard-panel',
  templateUrl: './student-dashboard.panel.html',
})

export class StudentDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    {
      this.items = [
        {
         title: 'Student Profile',
         route: '/secure/studentProfile',
         icon: 'assignment',
         color: 'blue-700',
         description: ' ',
         },
        {
        title: 'Profile',
        route: '/secure/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },

      ];
    }
  }
}
