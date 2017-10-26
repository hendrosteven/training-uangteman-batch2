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

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onUserRegister(){
    this.userService.register(this.user).subscribe(output=>{
        this.user = new User();
        this.success = true;
    },error=>{
      console.log(error);
    })
  }
}
