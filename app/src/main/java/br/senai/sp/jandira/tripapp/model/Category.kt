package br.senai.sp.jandira.tripapp.model

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter

data class Category(
    var id: Long = 0,
    var categoryName: String = "",
    var categoryIcon: Painter
)
