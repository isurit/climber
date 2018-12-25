package groundcontrol.climber.view.customFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import groundcontrol.climber.R
import groundcontrol.climber.view.fragmentInterface

class MainFragment : Fragment() {
    var interFace: fragmentInterface? = null

    fun setFragmentInterface(interF : fragmentInterface) {
        interFace = interF
    }

    companion object {
        fun newInstance() : MainFragment {
            return MainFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        var firstBtn = view.findViewById<Button>(R.id.firstBtn)
        firstBtn.setOnClickListener {
            interFace?.onArticleSelected(999, R.layout.first_fragment)
        }

        var secondBtn = view.findViewById<Button>(R.id.secondBtn)
        secondBtn.setOnClickListener {
            interFace?.onArticleSelected(999, R.layout.second_fragment)
        }

        var thirdBtn = view.findViewById<Button>(R.id.thirdBtn)
        thirdBtn.setOnClickListener {
            interFace?.onArticleSelected(999, R.layout.third_fragment)
        }
        return view
    }
}