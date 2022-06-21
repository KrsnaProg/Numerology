package hare.krshna.numerology.parsers.jsonParser

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonParserImpl(private val gson: Gson) : JsonParser {
  override fun parseJson(jsonString: String): Map<Char, Int> {
    val typeToken: TypeToken<Map<Char, Int>> = object : TypeToken<Map<Char, Int>>() {}
    return gson.fromJson(jsonString, typeToken.type)
  }
}