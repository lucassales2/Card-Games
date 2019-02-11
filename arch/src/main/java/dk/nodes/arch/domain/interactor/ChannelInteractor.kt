package dk.nodes.arch.domain.interactor

import kotlinx.coroutines.channels.ReceiveChannel

interface ChannelInteractor<R: Any> {

    suspend fun receiveChannel(): ReceiveChannel<R>

}