package groundcontrol.climber.view.customFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import groundcontrol.climber.R

class ThirdFragment : BaseFragment() {
    companion object {
        fun newInstance() : ThirdFragment {
            return ThirdFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.third_fragment, container, false)
        var backBtn = view.findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            interFace?.onArticleSelected(-1, 0)
        }
        return view
    }
}