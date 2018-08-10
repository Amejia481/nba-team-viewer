package com.arturomejiamarmol.nbateamview.teamdetails

import com.arturomejiamarmol.nbateamview.data.Team


class TeamDetailsContact {

  interface View {
    fun showTeam(team: Team)
  }

  interface Presenter {
    fun loadTeam(team: Team)
  }

}