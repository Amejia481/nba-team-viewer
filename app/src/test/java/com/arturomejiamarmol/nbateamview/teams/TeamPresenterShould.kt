package com.arturomejiamarmol.nbateamview.teams

import android.arch.lifecycle.MutableLiveData
import com.arturomejiamarmol.nbateamview.data.SortOrder
import com.arturomejiamarmol.nbateamview.data.Team
import com.arturomejiamarmol.nbateamview.data.TeamProvider
import com.arturomejiamarmol.nbateamview.data.TeamSortProvider
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class TeamPresenterShould {

  @Mock
  lateinit var presenter: TeamContract.Presenter

  @Mock
  lateinit var mockView: TeamContract.View

  @Mock
  lateinit var mockSortProvider: TeamSortProvider

  @Mock
  lateinit var mockTeamProvider: TeamProvider


  @Before
  fun before() {
    MockitoAnnotations.initMocks(this)
    presenter = TeamsPresenter(mockView, mockTeamProvider, mockSortProvider)
  }

  @Test
  fun loadTeams() {

    val data = MutableLiveData<List<Team>>()

    Mockito.`when`(mockTeamProvider.getTeams()).thenReturn(data)

    presenter.loadTeams()

    verify(mockTeamProvider).getTeams()

    verify(mockView).showTeamList(data)

  }

  @Test
  fun sortByWins() {
    val teams = listOf<Team>()
    presenter.sortByWinds(teams, SortOrder.DESCEND)
    verify(mockSortProvider).sortByWins(teams, SortOrder.DESCEND)
    verify(mockView).updateTeamList(teams)

  }

  @Test
  fun sortByLosses() {
    val teams = listOf<Team>()
    presenter.sortByLosses(teams, SortOrder.DESCEND)
    verify(mockSortProvider).sortByLosses(teams, SortOrder.DESCEND)
    verify(mockView).updateTeamList(teams)

  }

}