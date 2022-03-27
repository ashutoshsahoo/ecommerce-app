import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable()
export class OrdersBlockingService {

  url: string = environment.ordersApiUrl;

  constructor(private http: HttpClient) {}

  getOrders() {
    return this.http.get(this.url)
  }

}
