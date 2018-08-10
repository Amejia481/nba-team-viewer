package com.arturomejiamarmol.nbateamview.data

class KotlinCollectionsSortProvider : TeamSortProvider {

  override fun sortByWins(teams: List<Team>, order: SortOrder): List<Team> {
    return when (order) {
      SortOrder.ASCENDANT -> {
        teams.sortedBy { it.wins }
      }
      SortOrder.DESCEND -> {
        teams.sortedByDescending { it.wins }

      }
    }
  }

  override fun sortByLosses(teams: List<Team>, order: SortOrder): List<Team> {
    return when (order) {
      SortOrder.ASCENDANT -> {
        teams.sortedBy { it.losses }
      }
      SortOrder.DESCEND -> {
        teams.sortedByDescending { it.losses }

      }
    }
  }

}