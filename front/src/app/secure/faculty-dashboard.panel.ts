import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-faculty-dashboard-panel',
  templateUrl: './faculty-dashboard.panel.html',
})

export class FacultyDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    {
      this.items = [{
        title: 'Faculty Profile',
        route: '/secure/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },
        {
          title: 'Faculty Planner',
          route: '/secure/planner',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        }
        ,
        {
          title: 'Faculty Term',
          route: '/secure/term',
          icon: 'description',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Faculty Graduation',
          route: '/secure/graduation',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Faculty Setup',
          route: '/secure/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },
      ];
    }
  }
}
