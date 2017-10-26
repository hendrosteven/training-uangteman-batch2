import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';
import {User} from '../classes/user.class';
import {LoginForm} from '../classes/login-form';
import {Md5} from 'ts-md5/dist/md5';

@Injectable()
export class UserService {

    url : string = 'http://localhost:8080/user';
    headers : any;
    options : any;

    constructor(private http : Http) {
        this.headers = new Headers({'Content-Type': 'application/json', 'Cache-Control': 'no-cache'});
        this.options = new RequestOptions({headers: this.headers});
    }

    register(user : User) {
        user.password = Md5.hashStr(user.password).toString();
        return this
            .http
            .post(this.url + '/register', user, this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    login(form : LoginForm) {
        return this
            .http
            .post(this.url + '/login', form, this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    handleError(error) {
        return Observable.throw(error.json() || 'Server error');
    }
}