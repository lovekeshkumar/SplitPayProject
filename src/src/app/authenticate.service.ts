import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/User';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { Group } from './model/Group';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  loginStatus: boolean
  currentUser: User
  allUsers: User[]

  constructor(public http: HttpClient) {
    this.loginStatus = false
  }

  signIn(user: User) {
    return this.http.post('http://172.18.218.142:' + environment.port + '/splitpay/signin', user, httpOptions)
  }

  signUp(user: User) {
    return this.http.post('http://172.18.218.142:' + environment.port + '/splitpay/signup', user, httpOptions)
  }

  signOut() {
    return this.http.post('http://172.18.218.142:' + environment.port + '/splitpay/signout', {}, httpOptions)
  }

  transaction() {
    return this.http.post('http://172.18.218.142:' + environment.port + '/splitpay/transaction/save', {}, httpOptions)
  }

  activities() {
    return this.http.get('http://172.18.218.142:' + environment.port + '/splitpay/view/all', {})
  }

  getAllUsers() {
    this.http.get<User[]>('http://172.18.218.142:' + environment.port + '/splitpay/users/all ', httpOptions)
      .subscribe(res => {
        this.allUsers = res.filter(user => {
          return user.id !== this.currentUser.id
        })
      })
  }

}
