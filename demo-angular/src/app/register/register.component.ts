import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user.class';
import { UserService } from '../services/user.service';

@Component({ 
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  success: boolean = false;
  errors: boolean = false;
  messages: string[] = [];

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onUserRegister(){
    this.userService.register(this.user).subscribe(output=>{
        this.user = new User();
        this.success = true;
    },error=>{
      this.errors = true;
      console.log(error);
      this.messages = error.messages
    })
  }
}
