package groundcontrol.climber.view.customFragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import groundcontrol.climber.R
import groundcontrol.climber.view.customComponent.AComponent
import groundcontrol.climber.viewmodel.AData
import kotlinx.android.synthetic.main.first_fragment.view.*


class FirstFragment : BaseFragment() {
    var testEnable = false
    companion object {
        fun newInstance() : FirstFragment {
            return FirstFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.first_fragment, container, false)

        var aData = ViewModelProviders.of(this).get(AData::class.java)
        var aComponent = AComponent(this, aData)
        view.contentsLayout.addView(aComponent)

        view.backBtn.setOnClickListener {
            interFace?.onArticleSelected(-1, 0)
        }

        view.nextBtn.setOnClickListener {
            interFace?.onArticleSelected(999, R.layout.aaa_fragment)
        }

        return view
    }
}