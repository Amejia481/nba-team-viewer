package com.arturomejiamarmol.nbateamview.teamdetails

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arturomejiamarmol.nbateamview.R
import com.arturomejiamarmol.nbateamview.data.Player

class PlayersAdapter(private val players: List<Player>, private val teamColor: Int) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.player_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val player = players[position]

    with(player) {
      val fullName = "$firstName $lastName"

      holder.name.text = fullName
      holder.position.text = "$position"
      holder.number.text = "$number"

      holder.initials.text = getInitials(fullName)
      holder.initials.setBackgroundColor(teamColor)
    }

  }

  private fun getInitials(teamName: String): String {

    val firstLetter = teamName.substring(0, 1)
    val secondLetter = teamName.substringAfter(' ').substring(0, 1)

    return firstLetter + secondLetter
  }

  override fun getItemCount(): Int = players.size

  inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.player_name)
    val position: TextView = view.findViewById(R.id.position)
    val number: TextView = view.findViewById(R.id.number)
    val initials: TextView = view.findViewById(R.id.team_initials)
  }

}


