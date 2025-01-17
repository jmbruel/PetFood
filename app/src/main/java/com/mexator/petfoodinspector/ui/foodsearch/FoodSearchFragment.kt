package com.mexator.petfoodinspector.ui.foodsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.mexator.petfoodinspector.databinding.FragmentFoodSearchBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

class FoodSearchFragment : Fragment() {
    private lateinit var binding: FragmentFoodSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private val searchSubject: BehaviorSubject<String> = BehaviorSubject.create()
    init {
        searchSubject.onNext("")
    }

    /**
     * Emits trimmed, lower-cased search queries. Includes debounce already
     */
    val searchObservable: Observable<String> = searchSubject
        .map(String::trim)
        .map(String::toLowerCase)
        .debounce(400, TimeUnit.MILLISECONDS)

    private val onQueryTextListener = object : SearchView.OnQueryTextListener {
        // We listen to every change, so we can ignore submit events
        override fun onQueryTextSubmit(query: String?): Boolean = true

        override fun onQueryTextChange(newText: String?): Boolean {
            searchSubject.onNext(newText)
            return true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.foodSearch.setOnQueryTextListener(onQueryTextListener)
    }
}