package br.senai.sp.jandira.tripapp.repository

import br.senai.sp.jandira.tripapp.model.Trip
import java.time.LocalDate

class TripRepository {

    companion object {
        fun getTrips(): List<Trip> {
            return listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Descricao Jandira",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4, 23),
                ), Trip(
                    id = 2,
                    location = "Carapicuiba",
                    description = "Descricao Carapicuiba",
                    startDate = LocalDate.of(2023, 8, 21),
                    endDate = LocalDate.of(2023, 8, 23),
                ),
                Trip(
                    id = 3,
                    location = "Barueri",
                    description = "Descricao Barueri",
                    startDate = LocalDate.of(2023, 12, 21),
                    endDate = LocalDate.of(2023, 12, 23),
                )
            )
        }
    }
}