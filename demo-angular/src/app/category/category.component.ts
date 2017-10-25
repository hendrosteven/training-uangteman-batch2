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
  category: Category = new Category();
  
  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.onLoadData();
  }

  onLoadData(){
    this.categoryService.gatAllCategory().subscribe(output =>{
      console.log(output);
      this.categories = output;
    }, error=>{
      console.log(error);
    });
  }

  onSaveCategory(){
    this.categoryService.saveCategory(this.category).subscribe(output=>{
      this.categories.push(output);
    },error=>{
      console.log(error);
    });
  }

}
