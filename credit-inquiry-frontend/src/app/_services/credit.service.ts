import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreditModel } from '../_model/credit.model';

const API_URL = 'http://localhost:8080/api/creditos/';

@Injectable({
  providedIn: 'root'
})
export class CreditService {
  constructor(private http: HttpClient) { }

  findByNumberNfse(numberNfse: string): Observable<CreditModel[]> {
    return this.http.get<CreditModel[]>(API_URL + numberNfse);
  }

  findByNumberCredit(numberCredit: string): Observable<CreditModel[]> {
    return this.http.get<CreditModel[]>(API_URL + 'credito/' + numberCredit);
  }

}
