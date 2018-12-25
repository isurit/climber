package groundcontrol.climber.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import groundcontrol.climber.R
import groundcontrol.climber.view.customFragment.*

class MainActivity : AppCompatActivity() , fragmentInterface{

    override fun onArticleSelected(position: Int, fragmentResource: Int) {
        when(position){
            999-> {
                Log.d("Climber", "$position , $fragmentResource")
                launchFragment(fragmentResource)
            }

            -1-> {
                var fragment = MainFragment.newInstance()
                fragment.setFragmentInterface(this)
                supportFragmentManager
                        .beginTransaction()
                        .apply { setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out) }
                        .replace(R.id.main_contents, fragment).commit()
            }
        }
    }

    private fun getFragment(fragmentResource: Int) : Fragment {
        lateinit var fragment : BaseFragment

        when(fragmentResource) {
            R.layout.aaa_fragment->fragment = AAAFragment.newInstance()
            R.layout.first_fragment->fragment = FirstFragment.newInstance()
            R.layout.second_fragment->fragment = SecondFragment.newInstance()
            R.layout.third_fragment->fragment = ThirdFragment.newInstance()
        }
        fragment.setFragmentInterface(this)
        return fragment
    }

    private fun launchFragment(fragmentResource: Int) {
        var fragment = getFragment(fragmentResource)
        supportFragmentManager
                .beginTransaction()
                .apply { setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out) }
                .replace(R.id.main_contents, fragment).commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event?.repeatCount == 0) {
            Log.d("Climber", event.repeatCount.toString())
            onArticleSelected(-1, 0)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainFrag = MainFragment.newInstance()
        mainFrag.setFragmentInterface(this)
        supportFragmentManager.beginTransaction().replace(R.id.main_contents, mainFrag).commit()
    }
}
