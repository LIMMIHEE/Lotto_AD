package kr.hs.emirim.mirimhee.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    //로또 1번공의 이미지 사용
    val lottoImageStartId = R.drawable.ball_01
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //전달받은 결과 배열 가져오기
        val result = intent.getIntegerArrayListExtra("result")
        val name=intent.getStringExtra("name")
        val constellation=intent.getStringExtra("constellation")
        resultLabel.text = "랜덤으로 생성되는 \n 로또번호 입니다."
        if(!TextUtils.isEmpty(name)){
            resultLabel.text="${name} 님의 |n${SimpleDateFormat("yyyy년 mm월 dd일").format(Date())}\n 로또번호 입니다"
        }
        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text="${name} 님의 |n${SimpleDateFormat("yyyy년 mm월 dd일").format(Date())}\n 로또번호 입니다"
        }
        //전달받은 결과가 있을시에 실행
        result?.let{
            //결과에 맞게 공이미지 전환
            //전달 받은 결과가 정렬되었지 ㅇㄶ으므로 정렬해서 전달 -> sortBy
            updateLottoBallImage(result.sortedBy {it})
        }
    }

    fun updateLottoBallImage(result: List<Int>){
        //결과 사이즈가 6미만일 경우 에러뜰수 있으므로 널 리턴
        if(result.size<6) return

        //1부터 순서대로 이미지아이디 있으므로 결과값 -1하면 목표하는 이미지.
        //result[0]이 2번 공이면 ball_01에서 하나 뒤에 이미지가 된다
        imageView1.setImageResource(lottoImageStartId+(result[0]-1))
        imageView2.setImageResource(lottoImageStartId+(result[1]-1))
        imageView3.setImageResource(lottoImageStartId+(result[2]-1))
        imageView4.setImageResource(lottoImageStartId+(result[3]-1))
        imageView5.setImageResource(lottoImageStartId+(result[4]-1))
        imageView6.setImageResource(lottoImageStartId+(result[5]-1))
       }
}
