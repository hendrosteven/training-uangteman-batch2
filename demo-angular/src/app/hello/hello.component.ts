import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  hello = 'Welcome to Angular';
  
  data: string[] = [];
  
  constructor() {
    this.data.push('Data pertama');
    this.data.push('Data kedua');   
  }

  addToList(){
    this.data.push(this.hello);
  }

  ngOnInit() {
  }

}
