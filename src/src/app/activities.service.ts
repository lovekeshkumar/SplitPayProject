import { Injectable } from '@angular/core';
import { Transaction } from './model/Transaction';

@Injectable({
  providedIn: 'root'
})

export class ActivitiesService {

  myTransactions: Transaction[]
  myDebts: Transaction[]

  constructor(){
    this.myTransactions = []
    this.myDebts = []
  }

}
