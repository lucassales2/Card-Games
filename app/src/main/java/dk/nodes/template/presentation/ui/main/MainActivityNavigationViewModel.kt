package dk.nodes.template.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.nodes.template.util.Event
import javax.inject.Inject

class MainActivityNavigationViewModel @Inject constructor() : ViewModel(), MainNavigation {

    private val _sectionLiveData = MutableLiveData<Event<MainSection>>()
    val sectionLiveData: LiveData<Event<MainSection>> = _sectionLiveData
    override fun openMainSection(section: MainSection) {
        _sectionLiveData.postValue(Event(section))
    }
}