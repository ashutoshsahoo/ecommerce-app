import { Injectable, NgZone } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
const EventSource: any = window['EventSource'];

@Injectable()
export class OrdersReactiveService {

  url: string = environment.ordersApiUrl;

  orders: string[] = []

  constructor(private _zone: NgZone) {}

  getOrderStream() {
    this.orders = []
    return Observable.create((observer) => {
      let eventSource = new EventSource(this.url)
      eventSource.onmessage = (event) => {
        console.log('Received event: ', event)
        let json = JSON.parse(event.data)
        this.orders.push(json);
        this._zone.run(() => {
          observer.next(this.orders)
        })
      }
      eventSource.onerror = (error) => {
        if(eventSource.readyState === 0) {
          console.log('The stream has been closed by the server.')
          eventSource.close()
          this._zone.run(() => {
            observer.complete()
          })
        } else {
          this._zone.run(() => {
            observer.error('EventSource error: ' + error)
          })
        }
      }
    })
  }

}
