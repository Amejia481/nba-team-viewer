package com.arturomejiamarmol.nbateamview.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.arturomejiamarmol.nbateamview.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class JsonTeamProvider(private var context: Context) : TeamProvider {

  private val liveData = MutableLiveData<List<Team>>()


  override fun getTeams(): LiveData<List<Team>> {

    liveData.postValue(teams)

    return liveData
  }

  private val teams: List<Team> by lazy {

    val listType = object : TypeToken<List<Team>>() {}.type

    Gson().fromJson<List<Team>>(
        loadJSON(context, R.raw.input), listType)
  }

  private fun loadJSON(context: Context, resource: Int): String? {
    val json: String?
    try {
      val rawResource = context.resources.openRawResource(resource)
      val size = rawResource.available()
      val buffer = ByteArray(size)
      rawResource.read(buffer)
      rawResource.close()
      json = String(buffer)

    } catch (ex: IOException) {
      ex.printStackTrace()
      return null
    }

    return json
  }
}