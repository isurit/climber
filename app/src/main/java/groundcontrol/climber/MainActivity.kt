package groundcontrol.climber

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.textView)

        val clickBtnA = findViewById<Button>(R.id.clickBtnA)
        val clickBtnB = findViewById<Button>(R.id.clickBtnB)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getUsers()?.observe(this,Observer<String> {
            tv.text = it
        })

        clickBtnA.setOnClickListener {
            viewModel.setData((it as Button).text.toString())
        }
        clickBtnB.setOnClickListener {
            viewModel.setData((it as Button).text.toString())
        }
    }
}
