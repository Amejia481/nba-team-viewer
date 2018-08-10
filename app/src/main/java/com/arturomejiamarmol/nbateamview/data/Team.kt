package com.arturomejiamarmol.nbateamview.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

open class Team(
    @SerializedName("id") var id: Int,
    @SerializedName("full_name") var name: String,
    @SerializedName("wins") var wins: Int,
    @SerializedName("losses") var losses: Int,
    @SerializedName("players") var players: List<Player>) : Parcelable {

  constructor(source: Parcel) : this(
      source.readInt(),
      source.readString(),
      source.readInt(),
      source.readInt(),
      source.createTypedArrayList(Player.CREATOR)
  )

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeInt(id)
    writeString(name)
    writeInt(wins)
    writeInt(losses)
    writeTypedList(players)
  }

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<Team> = object : Parcelable.Creator<Team> {
      override fun createFromParcel(source: Parcel): Team = Team(source)
      override fun newArray(size: Int): Array<Team?> = arrayOfNulls(size)
    }
  }
}
