package com.arturomejiamarmol.nbateamview.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Player(
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("position") var position: String,
    @SerializedName("number") var number: Int) : Parcelable {

  constructor(source: Parcel) : this(
      source.readString(),
      source.readString(),
      source.readString(),
      source.readInt()
  )

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeString(firstName)
    writeString(lastName)
    writeString(position)
    writeInt(number)
  }

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<Player> = object : Parcelable.Creator<Player> {
      override fun createFromParcel(source: Parcel): Player = Player(source)
      override fun newArray(size: Int): Array<Player?> = arrayOfNulls(size)
    }
  }
}
