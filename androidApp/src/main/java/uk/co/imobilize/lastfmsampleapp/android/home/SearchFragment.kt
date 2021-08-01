package uk.co.imobilize.lastfmsampleapp.android.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.scope.currentScope
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.scope.scopeActivity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uk.co.imobilize.lastfmsampleapp.android.R
import uk.co.imobilize.lastfmsampleapp.android.databinding.SearchFragmentBinding
import uk.co.imobilize.lastfmsampleapp.android.home.artists.ArtistsFragment
import uk.co.imobilize.lastfmsampleapp.android.show
import uk.co.imobilize.lastfmsampleapp.android.showError
import uk.co.imobilize.lastfmsampleapp.controllers.EventsControllerDelegate
import uk.co.imobilize.lastfmsampleapp.controllers.SearchController
import uk.co.imobilize.lastfmsampleapp.controllers.SearchControllerState

class SearchFragment: Fragment(R.layout.search_fragment), KoinComponent, EventsControllerDelegate {

    val searchController: SearchController by inject()

    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchController.delegate = this
        searchController.coroutineScope = CoroutineScope(Dispatchers.IO)

        binding.searchView.apply {

            setIconifiedByDefault(false)    // do not iconify the widget; expand it by default

            imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI // avoid fullscreen with softkeyboard

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {

                    searchController.searchArtists(query)
                    return true    // return true to prevent the query is processed to be queried;
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false   // let it for the parent listener in the hierarchy / default behaviour
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()
        // focus the search view and request the software keyboard be shown
        if (binding.searchView.requestFocus()) {
            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.searchView.findFocus(), InputMethodManager.SHOW_IMPLICIT)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hideSoftKeyboard()

    }


    private fun hideSoftKeyboard() {
        view?.let {
            view?.findViewById<View>(R.id.searchView)?.let {
                val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.searchView.windowToken, 0)
            }
        }
    }

    fun showLoading() {
        binding?.loadingProgressBar?.visibility = View.VISIBLE
    }

    fun hideLoading() {
        binding?.loadingProgressBar?.visibility = View.INVISIBLE
    }

    override fun stateUpdated(updatedState: SearchControllerState) {

        when(updatedState) {
            is SearchControllerState.Loading -> {
                showLoading()
            }
            is SearchControllerState.Failed -> {
                hideLoading()

                showError("Search Failed", updatedState.message)
            }
            is SearchControllerState.ShowArtists -> {

                hideLoading()

                val artistsFragment = ArtistsFragment(updatedState.artists)

                fragmentManager?.let {
                    artistsFragment.show(it, true)
                }
            }
        }
    }

}