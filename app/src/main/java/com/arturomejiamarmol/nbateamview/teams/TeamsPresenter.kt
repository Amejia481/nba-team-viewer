package com.arturomejiamarmol.nbateamview.teams

import com.arturomejiamarmol.nbateamview.data.SortOrder
import com.arturomejiamarmol.nbateamview.data.Team
import com.arturomejiamarmol.nbateamview.data.TeamProvider
import com.arturomejiamarmol.nbateamview.data.TeamSortProvider
import com.arturomejiamarmol.nbateamview.teams.TeamContract.View

class TeamsPresenter(
    private val view: View,
    private val teamProvider: TeamProvider,
    private val sortProvider: TeamSortProvider) : TeamContract.Presenter {

  override fun sortByWinds(teams: List<Team>, order: SortOrder) {
    val sortedList = sortProvider.sortByWins(teams, order)
    view.updateTeamList(sortedList)

  }

  override fun sortByLosses(teams: List<Team>, order: SortOrder) {
    val sortedList = sortProvider.sortByLosses(teams, order)
    view.updateTeamList(sortedList)
  }

  override fun loadTeams() {

    val teamData = teamProvider.getTeams()
    view.showTeamList(teamData)

  }
}