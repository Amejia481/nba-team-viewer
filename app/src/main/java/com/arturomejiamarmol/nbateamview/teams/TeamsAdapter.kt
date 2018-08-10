package com.arturomejiamarmol.nbateamview.teams

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arturomejiamarmol.nbateamview.R
import com.arturomejiamarmol.nbateamview.data.Team

class TeamsAdapter(private var teams: List<Team>, private val teamListener: TeamActionLister) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.team_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val team = teams[position]

    with(team) {
      val context = holder.teamName.context
      val colorGood = ContextCompat.getColor(context, R.color.good)
      val colorBad = ContextCompat.getColor(context, R.color.bad)

      holder.teamName.text = name
      holder.wins.text = "$wins"
      holder.losses.text = "$losses"

      holder.initials.text = getInitials(name)
      holder.initials.setBackgroundColor(if (wins > losses) colorGood else colorBad)

    }

    holder.mView.setOnClickListener {
      teamListener.onTeamClick(team)
    }
  }

  private fun getInitials(teamName: String): String {

    val firstLetter = teamName.substring(0, 1)
    val secondLetter = teamName.substringAfter(' ').substring(0, 1)

    return firstLetter + secondLetter
  }

  override fun getItemCount(): Int = teams.size

  fun getTeams():List<Team>{
    return teams
  }

  fun updateTeams(newTeams: List<Team>){
    teams =  newTeams
    notifyDataSetChanged()
  }

  inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
    val teamName: TextView = mView.findViewById<TextView>(R.id.team_name)
    val wins: TextView = mView.findViewById<TextView>(R.id.wins)
    val losses: TextView = mView.findViewById<TextView>(R.id.losses)
    val initials: TextView = mView.findViewById<TextView>(R.id.team_initials)
  }

  interface TeamActionLister {
    fun onTeamClick(team: Team)
  }

}


