package hare.krshna.numerology.presentation.scanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hare.krshna.numerology.databinding.FragmentScannerBinding

class ScannerFragment : Fragment() {

  private lateinit var binding: FragmentScannerBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentScannerBinding.inflate(inflater, container, false)
    return binding.root
  }

  companion object {
    const val TAG = "ScannerFragmentTAG"
  }
}