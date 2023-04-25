package br.senai.sp.jandira.tripapp.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.model.Category

class CategoryRepository {

    companion object {
        @Composable
        fun getCategories(): List<Category> {
            return listOf(
                Category(
                    id = 1,
                    categoryName = "Montanha",
                    categoryIcon = painterResource(id = R.drawable.montain)
                ),
                Category(
                    id = 2,
                    categoryName = "Snow",
                    categoryIcon = painterResource(id = R.drawable.ski)
                ),
                Category(
                    id = 3,
                    categoryName = "Beach",
                    categoryIcon = painterResource(id = R.drawable.beach)
                ),
                Category(
                    id = 4,
                    categoryName = "Business",
                    categoryIcon = painterResource(id = R.drawable.business)
                )
            )
        }
    }
}