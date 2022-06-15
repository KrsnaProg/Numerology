package hare.krshna.numerology.parsers.jsonParcer

import android.content.res.Resources

class RawJsonReaderImpl(private val resources: Resources) : RawJsonReader {
  override fun readJson(rawId: Int): String {
    val stream = resources.openRawResource(rawId)
    val result = String(stream.readBytes())
    stream.close()
    return result
  }
}