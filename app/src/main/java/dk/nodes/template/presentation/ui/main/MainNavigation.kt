package dk.nodes.template.presentation.ui.main

interface MainNavigation {
    fun openMainSection(section: MainSection)
}

enum class MainSection {
    Trending, Search, Favorites
}