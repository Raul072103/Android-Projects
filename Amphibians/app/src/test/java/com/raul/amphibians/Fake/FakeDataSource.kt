package com.raul.amphibians.Fake

import com.raul.amphibians.model.AmphibiansInfo
import kotlinx.serialization.SerialName

object FakeDataSource {

    val name1: String = "Rex"
    val type1: String = "Dog"
    val description1: String = "He likes to run"
    val imgSrc1: String = "somewhereintheweb.one"

    val name2: String = "Vlad"
    val type2: String = "Cat"
    val description2: String = "He likes to sleep"
    val imgSrc2: String = "somewhereintheweb.two"

    val amphibiansList = listOf<AmphibiansInfo>(
        AmphibiansInfo(
            name = name1,
            type = type1,
            description = description1,
            imgSrc = imgSrc1
        ),
        AmphibiansInfo(
            name = name2,
            type = type2,
            description = description2,
            imgSrc = imgSrc2
        )
    )

}