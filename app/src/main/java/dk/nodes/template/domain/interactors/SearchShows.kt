package dk.nodes.template.domain.interactors

import dk.nodes.arch.domain.interactor.ChannelInteractor
import dk.nodes.arch.util.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SearchShows @Inject constructor(
    private val searchRepository: SearchRepository,
    dispatchers: AppCoroutineDispatchers
) : ChannelInteractor<SearchShows.Params, SearchResults>() {
    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun execute(executeParams: Params): SearchResults {
        return searchRepository.search(executeParams.query)
    }

    data class Params(val query: String)
}