import { Component, OnInit } from '@angular/core';
import { ActivitiesService } from '../activities.service';
import { AuthenticateService } from '../authenticate.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Transaction } from '../model/Transaction';
import { ActivatedRoute } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {

  type: string

  constructor(public http: HttpClient, public authService: AuthenticateService, public transService: ActivitiesService, public route: ActivatedRoute) {
    this.type = route.snapshot.paramMap.get('type')
    if(this.type === 'payments'){
      this.getMyTransactions()
    }
    else if(this.type === 'debts'){
      this.getMyDebts()
    }
  }

  ngOnInit() {
    console.log('init' + this.route.snapshot.paramMap.get('type'))
  }

  getMyTransactions() {
    this.http.get<Transaction[]>('http://172.18.218.142:' + environment.port + '/splitpay/transactions/paidby/' + this.authService.currentUser.id, httpOptions)
      .subscribe(res => {
        console.log(res)
        this.transService.myTransactions = res
      })
  }

  getMyDebts() {
    this.http.get<Transaction[]>('http://172.18.218.142:' + environment.port + '/splitpay/transactions/paidfor/' + this.authService.currentUser.id, httpOptions)
      .subscribe(res => {
        console.log(res)
        this.transService.myDebts = res
      })
  }

}
