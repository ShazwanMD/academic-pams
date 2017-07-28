import {AfterViewInit, Component} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {TdLoadingService} from '@covalent/core';

@Component({
  selector: 'pams-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
  viewProviders: [],
})
export class DashboardComponent implements AfterViewInit {

  constructor(private _titleService: Title,
              private _loadingService: TdLoadingService) {
  }

  ngAfterViewInit(): void {
    this._titleService.setTitle('Centre for Postgraduate Studies Universiti Malaysia Kelantan');
  }
}
