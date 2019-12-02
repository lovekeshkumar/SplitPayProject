import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { Transaction } from '../model/Transaction';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  transaction: Transaction
  successFlag: boolean

  constructor(public authService: AuthenticateService, public http: HttpClient) {
    this.transaction = new Transaction()
    this.successFlag = false
  }

  ngOnInit() {
    this.authService.getAllUsers()
  }

  addTransaction(addForm) {
    this.successFlag = false

    this.transaction.bfk = this.authService.currentUser.id
    this.transaction.ffk = parseInt(this.transaction.ffk + '')

    this.http.post<Transaction>('http://172.18.218.142:' + environment.port + '/splitpay/transactions/save', this.transaction, httpOptions)
      .subscribe(res => {
        console.log(res)
        if (res.tid > 0) {
          this.successFlag = true
          this.transaction = new Transaction()
          addForm.form.markAsPristine()
        }
      })


  }

}
