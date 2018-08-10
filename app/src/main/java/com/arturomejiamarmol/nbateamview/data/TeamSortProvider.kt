package com.arturomejiamarmol.nbateamview.data


interface TeamSortProvider {

  fun sortByWins(teams: List<Team>, order: SortOrder): List<Team>

  fun sortByLosses(teams: List<Team>, order: SortOrder): List<Team>
}