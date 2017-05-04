import {Component} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'pams-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
})
export class MainComponent {

  routes: Object[] = [{
    title: 'Dashboard',
    route: '/',
    icon: 'dashboard',
  }, {
    title: 'Profile',
    route: '/profile',
    icon: 'assignment',
  }, {
    title: 'Planner',
    route: '/planner',
    icon: 'assignment',
  }, {
    title: 'Term',
    route: '/term',
    icon: 'assignment',
  }, {
    title: 'Graduation',
    route: '/graduation',
    icon: 'assignment',
  },  {
    title: 'Test_TEST',
    route: '/testest',
    icon: 'assignment',
  }
  ];

  constructor(private _router: Router) {
  }

  logout(): void {
    this._router.navigate(['/login']);
  }
}
