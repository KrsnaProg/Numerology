package hare.krshna.numerology.parsers.jsonParcer

import androidx.annotation.RawRes

interface RawJsonReader {
  fun readJson(@RawRes rawId: Int): String
}