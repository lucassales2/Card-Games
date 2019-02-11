package dk.nodes.arch.domain.interactor.sample

import dk.nodes.arch.domain.interactor.Result
import dk.nodes.arch.domain.interactor.ResultInteractor
import dk.nodes.arch.util.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by bison on 10/10/17.
 */
class AddTwoNumbersResultInteractor(
    dispatchers: AppCoroutineDispatchers
) : AddTwoNumbersInteractor, ResultInteractor<AddTwoNumbersInteractor.Input, Int>() {
    override suspend fun execute(executeParams: AddTwoNumbersInteractor.Input): Result<Int> {
        return Result.Success(executeParams.firstNumber + executeParams.secondNumber)
    }

    override val dispatcher: CoroutineDispatcher = dispatchers.io

}