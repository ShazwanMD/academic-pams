import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-ptj-dashboard-panel',
  templateUrl: './ptj-dashboard.panel.html',
})

export class PTJDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    {
      this.items = [{
        title: 'PTJ Profile',
        route: '/secure/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },
        {
          title: 'PTJ Planner',
          route: '/secure/planner',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        }
        ,
        {
          title: 'PTJ Term',
          route: '/secure/term',
          icon: 'description',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'PTJ Graduation',
          route: '/secure/graduation',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'PTJ Setup',
          route: '/secure/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },
      ];
    }
  }
}
