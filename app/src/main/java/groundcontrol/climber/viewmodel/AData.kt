package groundcontrol.climber.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log

class AData :ViewModel() {
    var title = "Title"

    private var isEnable=  MutableLiveData<Boolean>()

    fun getEnableObserve() : LiveData<Boolean>? {
        return isEnable
    }

    fun setEnable(enabled: Boolean) {
        Log.d("Climber", "setEnable : $enabled")
        isEnable.value = enabled
    }

    fun getEnable() : Boolean? {
        return isEnable.value
    }
}