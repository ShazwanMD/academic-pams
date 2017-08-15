import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-administrator-dashboard-panel',
  templateUrl: './administrator-dashboard.panel.html',
})

export class AdministratorDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    {
      this.items = [{
        title: 'Profile',
        route: '/secure/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },
        {
          title: 'Planner',
          // route: '/secure/planner/academic-sessions',
          route: '/secure/planner',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        }
        ,
        {
          title: 'Term',
          route: '/secure/term',
          icon: 'description',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Graduation',
          route: '/secure/graduation',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Setup',
          route: '/secure/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },
      ];
    }
  }
}
