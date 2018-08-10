package com.arturomejiamarmol.nbateamview.teamdetails

import com.arturomejiamarmol.nbateamview.data.Team
import com.arturomejiamarmol.nbateamview.teamdetails.TeamDetailsContact.View

class TeamDetailsPresenter(private val view: View) : TeamDetailsContact.Presenter {

  override fun loadTeam(team: Team) {
    view.showTeam(team)
  }
}