package br.senai.sp.jandira.tripapp.model

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(true)
    var id: Long = 0,
    @ColumnInfo(name = "user_name")
    var userName: String = "",
    var email: String = "",
    var password: String = "",
    var phone: String = "",
    @ColumnInfo(name = "is_over_18")
    var isOver18: Boolean = false,
    @ColumnInfo(name = "profile_photo")
    var profilePhoto: String = ""
)
