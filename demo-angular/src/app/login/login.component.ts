import { Component, OnInit } from '@angular/core';
import { LoginForm } from '../classes/login-form';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { Md5 } from 'ts-md5/dist/md5';

@Component({ 
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: LoginForm = new LoginForm();
  errors: boolean = false;
  
  constructor(private userService: UserService, 
        private router: Router) { }

  ngOnInit() {
  }

  onUserLogin(){
    this.userService.login(this.loginForm).subscribe(output=>{
      let hash = Md5.hashStr(this.loginForm.password).toString();
      let token = btoa(this.loginForm.email + ':' + hash);  
      localStorage.setItem('token', token);
      console.log(token);
      this.router.navigate(['product']);
    },error=>{
      this.errors = true;
      console.log(error);
    });
  }

}
