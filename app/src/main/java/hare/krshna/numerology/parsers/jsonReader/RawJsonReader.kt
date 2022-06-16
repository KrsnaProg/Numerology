package hare.krshna.numerology.parsers.jsonReader

import androidx.annotation.RawRes

interface RawJsonReader {
  fun readJson(@RawRes rawId: Int): String
}