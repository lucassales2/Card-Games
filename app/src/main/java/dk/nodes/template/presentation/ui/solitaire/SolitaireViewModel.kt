package dk.nodes.template.presentation.ui.solitaire

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dk.nodes.arch.util.AppCoroutineDispatchers
import dk.nodes.template.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lucassales.com.FoundationPile
import lucassales.com.Solitaire
import lucassales.com.TableauPile
import javax.inject.Inject

class SolitaireViewModel @Inject constructor(
    private val appCoroutineDispatchers: AppCoroutineDispatchers
) :
    BaseViewModel() {
    private val _viewState = MutableLiveData<SolitaireViewState>()
    val viewState: LiveData<SolitaireViewState> = _viewState

    init {
        Solitaire.reset()
        updateViewState()
    }

    fun onDeckClick() {
        viewModelScope.launch {
            withContext(appCoroutineDispatchers.io) { Solitaire.tapDeck() }
            updateViewState()
        }
    }

    fun onWastePileClick() {
        viewModelScope.launch {
            withContext(appCoroutineDispatchers.io) { Solitaire.tapWaste() }
            updateViewState()
        }
    }

    fun onFoundationPileClick(foundationPile: FoundationPile) {
        viewModelScope.launch {
            withContext(appCoroutineDispatchers.io) { Solitaire.tapFoundation(foundationPile) }
            updateViewState()
        }
    }

    fun onTableauPileClick(tableauPile: TableauPile) {
        viewModelScope.launch {
            withContext(appCoroutineDispatchers.io) { Solitaire.tapTableau(tableauPile) }
            updateViewState()
        }
    }

    private fun updateViewState() {
        _viewState.postValue(
            SolitaireViewState(
                deck = Solitaire.deck,
                wastePile = Solitaire.wastePile,
                foundationPiles = Solitaire.foundationPiles.toList(),
                tableauPiles = Solitaire.tableauPiles.toList()
            )
        )
    }
}