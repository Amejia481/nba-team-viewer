package com.arturomejiamarmol.nbateamview.data

import android.arch.lifecycle.LiveData


interface TeamProvider {

  fun getTeams(): LiveData<List<Team>>

}