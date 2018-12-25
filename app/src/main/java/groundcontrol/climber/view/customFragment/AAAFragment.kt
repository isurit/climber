package groundcontrol.climber.view.customFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import groundcontrol.climber.R
import kotlinx.android.synthetic.main.aaa_fragment.view.*

class AAAFragment : BaseFragment() {
    companion object {
        fun newInstance() : AAAFragment {
            return AAAFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.aaa_fragment, container, false)

        view.backBtn.setOnClickListener {
            interFace?.onArticleSelected(999, R.layout.first_fragment)
        }
        return view
    }
}