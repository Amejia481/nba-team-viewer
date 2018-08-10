package com.arturomejiamarmol.nbateamview.data

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JsonTeamProviderTestShould {

  lateinit var appContext: Context

  lateinit var provider : JsonTeamProvider

  @Before
  fun setup() {

    appContext = InstrumentationRegistry.getInstrumentation()
        .targetContext
        .applicationContext

    provider = JsonTeamProvider(appContext)
  }

  @Test
  fun readJsonFileFromRawFile() {

    val teams = provider.getTeams().value

    assert(teams?.isNotEmpty() == true)

  }
}