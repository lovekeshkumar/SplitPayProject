import { Component, OnInit } from '@angular/core';
import { Group } from '../model/Group';
import { AuthenticateService } from '../authenticate.service';
import { Router, Event, NavigationEnd } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  successFlag: boolean
  errorFlag: boolean
  group: Group

  constructor(public authService: AuthenticateService, public router: Router, public http: HttpClient) {
    this.initGroup()
  }

  ngOnInit() { }


  groupSubmit(groupForm) {

    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };

    this.http.post('http://172.18.218.175:' + environment.port + '/splitpay/group/save', this.group, httpOptions)
      .subscribe(res => {
        this.successFlag = true
      }, err => {
        this.errorFlag = true
      })

  }

  initGroup() {
    this.group = {
      groupId: 0,
      groupName: '',
    }
  }
}