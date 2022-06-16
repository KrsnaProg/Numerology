package hare.krshna.numerology.parsers.jsonParce

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class jsonParceImpl: jsonParce {
    override fun parceJson(jsonString: String): Map<Char, Int> {
        val gsonParser = Gson()
        val typeTok: TypeToken<Map<Char, Int>> = object : TypeToken<Map<Char, Int>>() {}
        val numerologicalValuesDict = gsonParser.fromJson<Map<Char, Int>>(jsonString, typeTok.type)
        return numerologicalValuesDict
    }
}