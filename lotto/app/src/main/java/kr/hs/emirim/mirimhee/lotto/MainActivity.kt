package kr.hs.emirim.mirimhee.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

fun getRandomLottoNumber() : Int{
    return Random().nextInt(45)+1
}
fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for(i in 1..6){
        var number =0
        do{
            number = getRandomLottoNumber()
        }while (lottoNumbers.contains(number))
        lottoNumbers.add(getRandomLottoNumber())
    }
    return lottoNumbers
}

//shuffle 이용한 번호 생ㅅ성
fun getShuffleLottoNumbers():MutableList<Int>{
    val list = mutableListOf<Int>()
    for(number in 1..45){
        list.add(number)
    }

    list.shuffle()
    return list.subList(0,6)
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomCard.setOnClickListener {
            val intent=Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
            //ResultActivity를 시작하는 Intent를 만들고 startActivity로 실행
            startActivity(intent)
        }
        constellationCard.setOnClickListener {
            //ConstellationActivity 시작하는 Intent를 만들고 startActivity로 실행
            startActivity(Intent(this,ConstellationActivity::class.java))
        }
        nameCard.setOnClickListener {
            //NameActivity 시작하는 Intent를 만들고 startActivity로 실행
            startActivity(Intent(this,NameActivity::class.java))
        }

    }
}
