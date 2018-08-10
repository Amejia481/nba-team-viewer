package com.arturomejiamarmol.nbateamview.teams

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.arturomejiamarmol.nbateamview.R
import com.arturomejiamarmol.nbateamview.data.Injection
import com.arturomejiamarmol.nbateamview.data.SortOrder
import com.arturomejiamarmol.nbateamview.data.Team
import com.arturomejiamarmol.nbateamview.teamdetails.TeamDetailActivity
import kotlinx.android.synthetic.main.activity_teams.*
import kotlinx.android.synthetic.main.content_teams.*

class TeamsActivity : AppCompatActivity(), TeamsAdapter.TeamActionLister, TeamContract.View {

  private lateinit var presenter: TeamsPresenter
  private lateinit var teamAdapter: TeamsAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_teams)
    setSupportActionBar(toolbar)

    val teamProvider = Injection.provideTeamProvider(this)
    val sortProvider = Injection.provideTeamSortProvider()
    val view = this

    presenter = TeamsPresenter(view, teamProvider, sortProvider)

    presenter.loadTeams()

  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.teams_menu, menu)
    return true
  }

  override fun onTeamClick(team: Team) {
    val intent = TeamDetailActivity.getIntent(this, team)

    startActivity(intent)
  }

  override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

    R.id.sort_by_wins -> {

      presenter.sortByWinds(teamAdapter.getTeams(), SortOrder.DESCEND)
      true
    }

    R.id.sort_by_losses -> {
      presenter.sortByLosses(teamAdapter.getTeams(), SortOrder.DESCEND)

      true
    }

    else -> {
      // If we got here, the user's action was not recognized.
      // Invoke the superclass to handle it.
      super.onOptionsItemSelected(item)
    }
  }

  override fun showTeamList(teamsData: LiveData<List<Team>>) {
    teamsData.observe(this, Observer<List<Team>> {
      teamAdapter = TeamsAdapter(it as List<Team>, this)
      teamsRecyclerView.adapter = teamAdapter

    })
  }

  override fun updateTeamList(teams: List<Team>) {
    teamAdapter.updateTeams(teams)
  }
}
