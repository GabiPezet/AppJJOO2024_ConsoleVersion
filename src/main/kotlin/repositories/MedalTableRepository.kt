package repositories

import data.Country

object MedalTableRepository {

    private val countries = mutableListOf<Country>()

    init {
        countries.add(
            Country(
                1L,
                "Estados Unidos",
                1,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/2560px-Flag_of_the_United_States.svg.png",
                35,
                30,
                25
            )
        )

        countries.add(
            Country(
                2L,
                "China",
                2,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1024px-Flag_of_the_People%27s_Republic_of_China.svg.png",
                32,
                28,
                22
            )
        )

        countries.add(
            Country(
                3L,
                "Argentina",
                3,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2560px-Flag_of_Argentina.svg.png",
                28,
                24,
                20
            )
        )

        countries.add(
            Country(
                4L,
                "Alemania",
                3,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/640px-Flag_of_Germany.svg.png",
                24,
                20,
                18
            )
        )

        countries.add(
            Country(
                5L,
                "Japón",
                5,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/1200px-Flag_of_Japan.svg.png",
                22,
                18,
                16
            )
        )

        countries.add(
            Country(
                6L,
                "Reino Unido",
                6,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Flag_of_the_United_Kingdom_%281-2%29.svg/1200px-Flag_of_the_United_Kingdom_%281-2%29.svg.png",
                20,
                17,
                15
            )
        )

        countries.add(
            Country(
                7L,
                "Francia",
                7,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%29.svg/1200px-Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%29.svg.png",
                18,
                15,
                14
            )
        )

        countries.add(
            Country(
                8L,
                "Australia",
                8,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png",
                16,
                14,
                12
            )
        )

        countries.add(
            Country(
                9L,
                "Italia",
                9,
                "https://upload.wikimedia.org/wikipedia/commons/0/03/Flag_of_Italy.svg",
                14,
                12,
                10
            )
        )

        countries.add(
            Country(
                10L,
                "Canadá",
                10,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/800px-Flag_of_Canada_%28Pantone%29.svg.png",
                12,
                10,
                8
            )
        )
    }



    fun get() : List<Country> {
        return emptyList() //TODO Implementar solucion para obtener medallero
    }
}