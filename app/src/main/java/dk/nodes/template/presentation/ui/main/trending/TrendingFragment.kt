package dk.nodes.template.presentation.ui.main.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dk.nodes.template.presentation.base.BaseFragment

class TrendingFragment: BaseFragment() {
    companion object {
        fun newInstance() = TrendingFragment()
    }

    override fun onCreateView(inflater:LayoutInflater, container:ViewGroup?, savedInstanceState:Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}