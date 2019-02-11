package dk.nodes.arch.domain.interactor.sample

import dk.nodes.arch.domain.interactor.ChannelInteractor
import dk.nodes.arch.util.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel

class AddTwoNumbersChannelInteractor(dispatchers: AppCoroutineDispatchers) :
    ChannelInteractor<Int>, AddTwoNumbersInteractor {

    // Channel should be on repository layer
    private val channel = Channel<Int>()
    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun invoke(executeParams: AddTwoNumbersInteractor.Input) {
        channel.send(executeParams.firstNumber + executeParams.secondNumber)
    }

    override suspend fun receiveChannel() = channel

}