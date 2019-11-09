import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormatComponent } from './pages/format/format.component';
import { FormatEdicionComponent } from './pages/format/format-edicion/format-edicion.component';
import { GameResultsComponent } from './pages/gameResults/gameResults.component';
import { GameResultsEdicionComponent } from './pages/gameResults/gameResults-edicion/gameResults-edicion.component';
import { MatchComponent } from './pages/match/match.component';
import { MatchEdicionComponent } from './pages/match/match-edicion/match-edicion.component';
import { PhaseComponent } from './pages/phase/phase.component';
import { PhaseEdicionComponent } from './pages/phase/phase-edicion/phase-edicion.component';
import { PlayerComponent } from './pages/player/player.component';
import { PlayerEdicionComponent } from './pages/player/player-edicion/player-edicion.component';
import { StatisticsComponent } from './pages/statistics/statistics.component';
import { StatisticsEdicionComponent } from './pages/statistics/statistics-edicion/statistics-edicion.component';
import { TeamComponent } from './pages/team/team.component';
import { TeamEdicionComponent } from './pages/team/team-edicion/team-edicion.component';
import { TournamentComponent } from './pages/tournament/tournament.component';
import { TournamentEdicionComponent } from './pages/tournament/tournament-edicion/tournament-edicion.component';
import { UserEdicionComponent } from './pages/user/user-edicion/user-edicion.component';
import { UserComponent } from './pages/user/user.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    FormatComponent,
    FormatEdicionComponent,
    GameResultsComponent,
    GameResultsEdicionComponent,
    MatchComponent,
    MatchEdicionComponent,
    PhaseComponent,
    PhaseEdicionComponent,
    PlayerComponent,
    PlayerEdicionComponent,
    StatisticsComponent,
    StatisticsEdicionComponent,
    TeamComponent,
    TeamEdicionComponent,
    TournamentComponent,
    TournamentEdicionComponent,
    UserComponent,
    UserEdicionComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
