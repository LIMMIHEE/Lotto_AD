package kr.hs.emirim.mirimhee.lotto

import java.text.SimpleDateFormat
import java.util.*
import java.util.Random



object LottoNumberMaker {

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

    fun getRandomLottoNumber() : Int{
        return Random().nextInt(45)+1
    }


    fun getLottoNumbersFromHash(name:String):MutableList<Int>{
        val list = mutableListOf<Int>()
        for(number in 1..45){
            list.add(number)
        }
        val tragetString = SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).format(Date())+name
        list.shuffle(Random(name.hashCode().toLong()))

        return list.subList(0,6)
    }

    fun getShuffleLottoNumbers():MutableList<Int>{
        val list = mutableListOf<Int>()
        for(number in 1..45){
            list.add(number)
        }

        list.shuffle()
        return list.subList(0,6)
    }


}
