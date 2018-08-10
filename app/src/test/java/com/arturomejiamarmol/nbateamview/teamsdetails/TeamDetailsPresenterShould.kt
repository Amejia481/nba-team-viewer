package com.arturomejiamarmol.nbateamview.teamsdetails

import com.arturomejiamarmol.nbateamview.data.Team
import com.arturomejiamarmol.nbateamview.teamdetails.TeamDetailsContact
import com.arturomejiamarmol.nbateamview.teamdetails.TeamDetailsPresenter
import com.arturomejiamarmol.nbateamview.teams.TeamsPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class TeamDetailsPresenterShould {

  @Mock
  lateinit var mockView: TeamDetailsContact.View

  @Mock
  lateinit var mockTeam: Team


  lateinit var presenter: TeamDetailsContact.Presenter

  @Before
  fun before() {
    MockitoAnnotations.initMocks(this)
    presenter = TeamDetailsPresenter(mockView)
  }

  @Test
  fun loadTeam(){

    presenter.loadTeam(mockTeam)
    Mockito.verify(mockView).showTeam(mockTeam)


  }
}