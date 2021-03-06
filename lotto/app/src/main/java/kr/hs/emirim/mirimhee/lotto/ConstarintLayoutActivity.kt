package kr.hs.emirim.mirimhee.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class ConstarintLayoutActivity : AppCompatActivity() {

    fun makeConstellationString(month:Int,day:Int):String{
        val target = "${month+1}${String.format("%02f",day)}".toInt()
        when(target){
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else-> return "기타별자리"

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
    }
}
