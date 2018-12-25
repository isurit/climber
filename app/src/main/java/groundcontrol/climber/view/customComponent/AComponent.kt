package groundcontrol.climber.view.customComponent

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v4.app.Fragment
import android.widget.LinearLayout
import groundcontrol.climber.viewmodel.AData
import android.view.LayoutInflater
import groundcontrol.climber.R
import kotlinx.android.synthetic.main.a_component.view.*

class AComponent constructor(fragment : Fragment, aData : AData) : LinearLayout(fragment.context) {
    init {
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(infService) as LayoutInflater
        val view = li.inflate(R.layout.a_component, this, false)
        addView(view)

        view.aSwitch.setOnCheckedChangeListener { _, isChecked ->
            aData.setEnable(isChecked)
        }
        aData.getEnableObserve()?.observe(fragment, Observer<Boolean> {
            var enable = aData.getEnable()
            enable?.let {
                if (enable) {
                    aTextView.text = "true"
                } else {
                    aTextView.text = "false"
                }
            }
        })
    }
}