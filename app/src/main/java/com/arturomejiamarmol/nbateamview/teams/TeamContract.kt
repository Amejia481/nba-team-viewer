package com.arturomejiamarmol.nbateamview.teams

import android.arch.lifecycle.LiveData
import com.arturomejiamarmol.nbateamview.data.SortOrder
import com.arturomejiamarmol.nbateamview.data.Team


class TeamContract {

  interface View {
    fun showTeamList(teamsData: LiveData<List<Team>>)

    fun updateTeamList(teams: List<Team>)

  }

  interface Presenter {
    fun loadTeams()

    fun sortByWinds(teams: List<Team>, order: SortOrder)

    fun sortByLosses(teams: List<Team>, order: SortOrder)
  }
}