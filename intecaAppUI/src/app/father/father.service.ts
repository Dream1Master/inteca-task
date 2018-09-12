import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Father } from '../models/father.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class FatherService {

  constructor(private http:HttpClient) {}

  //private userUrl = 'http://localhost:8080/user-portal/user';
  private userUrl = '/api';

  public getFathers() {
    return this.http.get<Father[]>(this.userUrl + '/fathers');
  }

  public deleteFather(father) {
    return this.http.delete(this.userUrl + "/father/"+ father.id);
  }

  public createFather(father) {
    return this.http.post<Father>(this.userUrl + '/father', father);
  }

}