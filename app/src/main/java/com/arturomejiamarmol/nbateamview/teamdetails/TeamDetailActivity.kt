package com.arturomejiamarmol.nbateamview.teamdetails

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.arturomejiamarmol.nbateamview.R
import com.arturomejiamarmol.nbateamview.data.Team
import kotlinx.android.synthetic.main.activity_team_detail.*
import kotlinx.android.synthetic.main.content_team_detail.*
import kotlinx.android.synthetic.main.toolbar_team_details.*

class TeamDetailActivity : AppCompatActivity(), TeamDetailsContact.View {

  private lateinit var presenter: TeamDetailsContact.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_team_detail)
    setSupportActionBar(toolbar)

    val view = this

    presenter = TeamDetailsPresenter(view)

    val team = extractTeamFromIntent()

    if (team != null)
      presenter.loadTeam(team)
    else
      throw  IllegalArgumentException("The key $KEY_TEAM shouldn't be null")

  }

  private fun extractTeamFromIntent(): Team? {
    var team: Team? = null

    intent.let {
      team = it.extras[KEY_TEAM] as Team
    }

    return team
  }

  override fun showTeam(team: Team) {
    val colorGood = ContextCompat.getColor(this, R.color.good)
    val colorBad = ContextCompat.getColor(this, R.color.bad)

    val teamColor = if (team.wins > team.losses) colorGood else colorBad

    with(team) {

      team_name.text = name
      wins_label.text = "$wins"
      losses_label.text = "$losses"
    }
    players.adapter = PlayersAdapter(team.players, teamColor)
  }

  companion object {

    private const val KEY_TEAM = "KEY_TEAM"

    fun getIntent(context: Context, team: Team): Intent {
      return Intent(context, TeamDetailActivity::class.java).apply {
        putExtra(KEY_TEAM, team)
      }
    }
  }
}
