import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Transaction } from './model/Transaction';

@Injectable({
  providedIn: 'root'
})

export class ActivitiesService {

  transactions: Transaction[]

  constructor(){
    
  }

}
