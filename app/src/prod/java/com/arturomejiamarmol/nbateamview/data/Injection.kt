package com.arturomejiamarmol.nbateamview.data

import android.content.Context


object Injection {

  fun provideTeamProvider(context: Context): TeamProvider {

    return JsonTeamProvider(context)
  }

  fun provideTeamSortProvider(): TeamSortProvider {
    return KotlinCollectionsSortProvider()
  }

}