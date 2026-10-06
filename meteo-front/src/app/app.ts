import { Component, signal, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MeteoService, ConditionsMeteo } from './meteo.sevice';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  nomVille = '';

  lieu = signal('');
  conditions = signal<ConditionsMeteo | null>(null);
  erreur = signal('');

  private meteoService = inject(MeteoService);

  chercher(): void {
    this.erreur.set('');
    this.conditions.set(null);
    this.lieu.set('');

    const nom = this.nomVille.trim();

    if (!nom) {
      this.erreur.set('Saisissez une ville.');
      return;
    }

    this.meteoService.chercherVille(nom).subscribe({
      next: (ville) => {
        this.lieu.set(ville.name + ', ' + ville.country);

        this.meteoService.chercherMeteo(nom).subscribe({
          next: (resultat) => {
            this.conditions.set(resultat);
          },
          error: (err) => {
            this.erreur.set('Impossible de récupérer la météo.');
            console.error(err);
          }
        });
      },
      error: (err) => {
        this.erreur.set('Impossible de récupérer la ville.');
        console.error(err);
      }
    });
  }
}