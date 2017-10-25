import { Component, OnInit } from '@angular/core';
import { Category } from '../classes/category.class';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: Category[] = [];
  
  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.onLoadData();
  }

  onLoadData(){
    this.categoryService.gatAllCategory().subscribe(output =>{
      this.categories = output;
    }, error=>{
      console.log(error);
    });
  }

}
