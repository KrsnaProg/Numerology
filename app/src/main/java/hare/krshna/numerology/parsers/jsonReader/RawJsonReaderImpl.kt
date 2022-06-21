package hare.krshna.numerology.parsers.jsonReader

import android.content.res.Resources
import androidx.annotation.RawRes

class RawJsonReaderImpl(private val resources: Resources) : RawJsonReader {
  override fun readJson(@RawRes rawId: Int): String {
    val stream = resources.openRawResource(rawId)
    val result = String(stream.readBytes())
    stream.close()
    return result
  }
}