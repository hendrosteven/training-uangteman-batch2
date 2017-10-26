import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class CategoryService {

    url : string = 'http://localhost:8080/category';
    headers : any;
    options : any;

    constructor(private http : Http) {
        this.headers = new Headers({'Content-Type': 'application/json', 'Cache-Control': 'no-cache'});
        this.options = new RequestOptions({headers: this.headers});
    }

    gatAllCategory() {
        return this
            .http
            .get(this.url, this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    saveCategory(category) {
        let headers = new Headers({
            'Content-Type': 'application/json', 
            'Cache-Control': 'no-cache',
            'Authorization': ' Basic ' + localStorage.getItem('token')
        });
        let options = new RequestOptions({headers: headers});
        return this
            .http
            .post(this.url, category, options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    handleError(error) {
        return Observable.throw(error.json() || 'Server error');
    }
}