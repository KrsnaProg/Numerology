package hare.krshna.numerology.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import hare.krshna.numerology.R
import hare.krshna.numerology.databinding.FragmentTextInputBinding
import hare.krshna.numerology.numerology.NumerologyImpl
import hare.krshna.numerology.parsers.jsonParce.jsonParceImpl
import hare.krshna.numerology.parsers.jsonParcer.RawJsonReaderImpl


class TextInputFragment : Fragment() {
    private lateinit var binding: FragmentTextInputBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rawJsonReader = RawJsonReaderImpl(resources)
        val jsonStr = rawJsonReader.readJson(R.raw.numerological_chars_mapping)
        val numerologicalValuesDict = jsonParceImpl()
        binding.btnConfirm.setOnClickListener {
            val name = binding.etName.text.toString()
            val numerologyDetector = NumerologyImpl(numerologicalValuesDict.parceJson(jsonStr))

            Toast.makeText(
                requireContext(),
                numerologyDetector.computeValue(name).toString(),
                Toast.LENGTH_LONG
            )
                .show()
        }
    }

    companion object {
        const val TAG = "TextInputFragmentTAG"
    }

}