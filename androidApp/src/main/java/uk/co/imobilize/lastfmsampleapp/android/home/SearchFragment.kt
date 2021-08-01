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
import uk.co.imobilize.lastfmsampleapp.android.R
import uk.co.imobilize.lastfmsampleapp.android.databinding.SearchFragmentBinding

class SearchFragment: Fragment(R.layout.search_fragment) {

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

        binding.searchView.apply {

            setIconifiedByDefault(false)    // do not iconify the widget; expand it by default

            imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI // avoid fullscreen with softkeyboard

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
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

    override fun onDetach() {
        super.onDetach()
    }

    private fun hideSoftKeyboard() {
        view?.let {
            view?.findViewById<View>(R.id.searchView)?.let {
                val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.searchView.windowToken, 0)
            }
        }
    }
}