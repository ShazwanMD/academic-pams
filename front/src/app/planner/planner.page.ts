import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-planner-page',
  templateUrl: './planner.page.html',
})

export class PlannerPage implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;

  constructor(private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // this._route.params.subscribe(() => {
    // });
  }
}
