package com.arturomejiamarmol.nbateamview.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData


class InMemoryTeamProvider : TeamProvider {

  private val liveData = MutableLiveData<List<Team>>()

  private val teams = listOf<Team>(
      Team(1, "Boston Celtics", 45, 20,
          listOf()))

  override fun getTeams(): LiveData<List<Team>> {
    liveData.postValue(teams)

    return liveData
  }


}