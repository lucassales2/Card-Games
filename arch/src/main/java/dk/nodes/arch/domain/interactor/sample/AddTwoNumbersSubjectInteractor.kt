package dk.nodes.arch.domain.interactor.sample

import dk.nodes.arch.domain.interactor.SubjectInteractor
import dk.nodes.arch.extensions.toFlowable
import dk.nodes.arch.util.AppCoroutineDispatchers
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.CoroutineDispatcher

class AddTwoNumbersSubjectInteractor(dispatchers: AppCoroutineDispatchers) : SubjectInteractor<Unit, AddTwoNumbersInteractor.Input, Int>(), AddTwoNumbersInteractor {


    init {
        setParams(Unit)
    }
    // Observable should be on repository layer
    private val publishSubject = PublishSubject.create<Int>()

    override suspend fun execute(params: Unit, executeParams: AddTwoNumbersInteractor.Input) {
        publishSubject.onNext(executeParams.firstNumber + executeParams.secondNumber)
    }

    override fun createObservable(params: Unit): Flowable<Int> {
        return publishSubject.toFlowable()
    }

    override val dispatcher: CoroutineDispatcher = dispatchers.io
}