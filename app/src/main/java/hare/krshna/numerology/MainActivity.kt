package hare.krshna.numerology

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hare.krshna.numerology.databinding.ActivityMainBinding
import hare.krshna.numerology.fragments.ScannerFragment
import hare.krshna.numerology.fragments.TextInputFragment

class MainActivity : AppCompatActivity() {

  lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    drawFragment(TextInputFragment(), TextInputFragment.TAG)
    binding.ivText.setOnClickListener {
      binding.ivText.isSelected = true
      binding.ivScanner.isSelected = false
      drawFragment(TextInputFragment(), TextInputFragment.TAG)
    }
    binding.ivScanner.setOnClickListener {
      binding.ivScanner.isSelected = true
      binding.ivText.isSelected = false
      drawFragment(ScannerFragment(), ScannerFragment.TAG)
    }
  }

  private fun drawFragment(fragment: Fragment, tag: String) {
    if (supportFragmentManager.findFragmentByTag(tag) == null) {
      supportFragmentManager
        .beginTransaction()
        .replace(R.id.flDynamicFrame, fragment, tag)
        .commit()
    }
  }
}