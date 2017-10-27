import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {User} from '../classes/user.class';
import {UserService} from '../services/user.service';
import {ToastsManager} from 'ng2-toastr/ng2-toastr';

@Component({selector: 'app-register', templateUrl: './register.component.html', styleUrls: ['./register.component.css']})
export class RegisterComponent implements OnInit {

  user : User = new User();
  success : boolean = false;
  errors : boolean = false;
  messages : string[] = [];

  constructor(private userService : UserService, public toastr : ToastsManager, vcr : ViewContainerRef) {
    this
      .toastr
      .setRootViewContainerRef(vcr);
  }

  ngOnInit() {}

  onUserRegister() {
    this
      .userService
      .register(this.user)
      .subscribe(output => {
        this.user = new User();
        this.success = true;
      }, error => {
        this.toastr.error('This is not good!', 'Oops!');
        this.errors = true;
        console.log(error);
        this.messages = error.messages
      })
  }
}
