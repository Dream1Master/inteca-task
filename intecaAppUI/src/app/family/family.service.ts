import { Family } from '../models/family.model';
import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Father } from '../models/father.model';
import {Child} from '../models/child.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class FamilyService {

  constructor(private http: HttpClient) {}

  //private userUrl = 'http://localhost:8080/user-portal/user';
  private userUrl = '/family';

  public getAllFamilies() {
    return this.http.get<Family[]>(this.userUrl + '/families');
  }

  public getFamilyById(familyId) {
    console.log(familyId);
    return this.http.get<Family>(this.userUrl + '/family/' + familyId);
  }

  public createFamily(family) {
    return this.http.post<Family>(this.userUrl + '/family', family);
  }

  public createChild(child) {
    return this.http.post<Child>('/child' + '/child', child);
  }

}
