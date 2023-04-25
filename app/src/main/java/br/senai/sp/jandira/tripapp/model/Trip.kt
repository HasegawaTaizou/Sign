package br.senai.sp.jandira.tripapp.model

import androidx.compose.ui.graphics.painter.Painter
import br.senai.sp.jandira.tripapp.R
import java.time.LocalDate

data class Trip(
    var id: Long = 0,
    var location: String = "",
    var description: String = "",
    var startDate: LocalDate = LocalDate.of(2000, 1, 1),
    var endDate: LocalDate = LocalDate.of(2000, 1, 1),
    var image: Int? = R.drawable.no_photography_24
)
