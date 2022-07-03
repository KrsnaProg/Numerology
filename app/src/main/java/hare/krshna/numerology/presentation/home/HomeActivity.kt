package hare.krshna.numerology.presentation.home

import androidx.fragment.app.Fragment
import com.zuluft.api.controllers.activities.BaseActivity
import hare.krshna.numerology.R
import hare.krshna.numerology.databinding.ActivityMainBinding
import hare.krshna.numerology.presentation.scanner.ScannerFragment
import hare.krshna.numerology.presentation.searchHistory.SearchHistoryFragment
import hare.krshna.numerology.presentation.textInput.TextInputFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<HomeViewState, HomeViewModel>() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<HomeViewModel>()

    private fun drawFragment(fragment: Fragment, tag: String) {
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flDynamicFrame, fragment, tag)
                .commit()
        }
    }

    override fun prepareView() {
//        test()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivText.setOnClickListener {
            binding.ivText.isSelected = true
            binding.ivScanner.isSelected = false
            binding.ivSearchHistory.isSelected = false
            viewModel.onTextInputClickIntent()
        }
        binding.ivScanner.setOnClickListener {
            binding.ivText.isSelected = false
            binding.ivScanner.isSelected = true
            binding.ivSearchHistory.isSelected = false
            viewModel.onScannerClickIntent()
        }
        binding.ivSearchHistory.setOnClickListener{
            binding.ivScanner.isSelected = false
            binding.ivText.isSelected = false
            binding.ivSearchHistory.isSelected = true
            viewModel.onSearchHistoryClickIntent()
        }
    }

    override fun reflectState(state: HomeViewState) {
        if (state.goToScannerScreen == true) {
            drawFragment(ScannerFragment(), ScannerFragment.TAG)
        } else if (state.goToTextInputScreen == true) {
            drawFragment(TextInputFragment(), TextInputFragment.TAG)
        } else if (state.goToSearchHistoryScreen == true){
            drawFragment(SearchHistoryFragment.newInstance(), SearchHistoryFragment.TAG)
        }
    }

    override fun provideViewModel(): HomeViewModel {
        return viewModel
    }

//    private fun test() {
//        val observable = Observable.fromArray(2, 5, 6)
//            .switchMap {
//                Observable.fromArray(2 * it, 3 * it, 4 * it)
//            }
//            .async()
//            .subscribe {
//                Log.d("Luka", it.toString())
//            }
//
//    }
}