package groundcontrol.climber.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData

class MainViewModel : ViewModel() {
    private var users: MutableLiveData<String>? = null
    private var userData = "BaseData"
    fun getUsers(): LiveData<String>? {
        if (users == null) {
            users = MutableLiveData()
            loadUsers()
        }
        return users
    }
    private fun loadUsers(){
        users?.value = userData

    }

    fun setData(text: String) {
        userData = text
        loadUsers()
    }
}