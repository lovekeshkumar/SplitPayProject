import { Component, OnInit } from '@angular/core';
import { ActivitiesService } from '../activities.service';
import { AuthenticateService } from '../authenticate.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Transaction } from '../model/Transaction';

@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {


  constructor(public http: HttpClient, public authService: AuthenticateService, public transService: ActivitiesService) {


  }

  ngOnInit() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };

    this.http.get<Transaction[]>('http://172.18.218.175:' + environment.port + '/splitpay/transactions/search/71', httpOptions)
      .subscribe(res => {
        console.log(res)
        this.transService.transactions = res
      })
  }

}
