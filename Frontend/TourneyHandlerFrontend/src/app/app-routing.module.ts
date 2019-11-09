import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
import { UserComponent } from './pages/user/user.component';
import { UserEdicionComponent } from './pages/user/user-edicion/user-edicion.component';

const routes: Routes = [

  {path: 'format', component: FormatComponent, children: [
    {path: 'nuevo', component: FormatEdicionComponent},
    {path: 'edicion/:id', component: FormatEdicionComponent}
  ]},

  {path: 'gameResults', component: GameResultsComponent, children: [
    {path: 'nuevo', component: GameResultsEdicionComponent},
    {path: 'edicion/:id', component: GameResultsEdicionComponent}
  ]},

  {path: 'match', component: MatchComponent, children: [
    {path: 'nuevo', component: MatchEdicionComponent},
    {path: 'edicion/:id', component: MatchEdicionComponent}
  ]},

  {path: 'phase', component: PhaseComponent, children: [
    {path: 'nuevo', component: PhaseEdicionComponent},
    {path: 'edicion/:id', component: PhaseEdicionComponent}
  ]},

  {path: 'player', component: PlayerComponent, children: [
    {path: 'nuevo', component: PlayerEdicionComponent},
    {path: 'edicion/:id', component: PlayerEdicionComponent}
  ]},

  {path: 'statistics', component: StatisticsComponent, children: [
    {path: 'nuevo', component: StatisticsEdicionComponent},
    {path: 'edicion/:id', component: StatisticsEdicionComponent}
  ]},

  {path: 'team', component: TeamComponent, children: [
    {path: 'nuevo', component: TeamEdicionComponent},
    {path: 'edicion/:id', component: TeamEdicionComponent}
  ]},

  {path: 'tournament', component: TournamentComponent, children: [
    {path: 'nuevo', component: TournamentEdicionComponent},
    {path: 'edicion/:id', component: TournamentEdicionComponent}
  ]},

  {path: 'user', component: UserComponent, children: [
    {path: 'nuevo', component: UserEdicionComponent},
    {path: 'edicion/:id', component: UserEdicionComponent}
  ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
