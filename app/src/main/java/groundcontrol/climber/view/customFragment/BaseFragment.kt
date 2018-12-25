package groundcontrol.climber.view.customFragment

import android.support.v4.app.Fragment
import groundcontrol.climber.view.fragmentInterface

open class BaseFragment:Fragment() {
    var interFace: fragmentInterface? = null

    fun setFragmentInterface(interF : fragmentInterface) {
        interFace = interF
    }
}