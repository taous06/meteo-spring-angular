import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Ville {
  name: string;
  country: string;
}

export interface ConditionsMeteo {
  time: string;
  temperature_2m: number;
  relative_humidity_2m: number;
  apparent_temperature: number;
  precipitation: number;
  wind_speed_10m: number;
  weather_code: number;
}

@Injectable({
  providedIn: 'root'
})
export class MeteoService {
  private http = inject(HttpClient);

  chercherVille(nomVille: string): Observable<Ville> {
    return this.http.get<Ville>(
      'http://localhost:8081/api/meteo/ville',
      { params: { nom: nomVille } }
    );
  }

  chercherMeteo(nomVille: string): Observable<ConditionsMeteo> {
    return this.http.get<ConditionsMeteo>(
      'http://localhost:8081/api/meteo',
      { params: { nom: nomVille } }
    );
  }
}