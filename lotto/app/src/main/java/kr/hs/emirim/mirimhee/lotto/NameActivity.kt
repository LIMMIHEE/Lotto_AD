package kr.hs.emirim.mirimhee.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import kotlinx.android.synthetic.main.activity_name.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

fun getLottoNumbersFromHash(name:String):MutableList<Int>{
    val list = mutableListOf<Int>()
    for(number in 1..45){
        list.add(number)
    }
    val tragetString = SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).format(Date())+name
    list.shuffle(Random(name.hashCode().toLong()))

    return list.subList(0,6)
}

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        gobutton.setOnClickListener {
            if (TextUtils.isEmpty(editText.text.toString())){
                Toast.makeText(applicationContext,"이름을 입력해 주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
                val intent = Intent(this, ResultActivity::class.java)

                intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString())))
            intent.putExtra("name",editText.text.toString())
                startActivity(intent)
        }
        backbutton.setOnClickListener {
            finish()
        }
    }
}
