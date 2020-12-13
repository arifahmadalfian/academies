package com.arifahmadalfian.academies.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arifahmadalfian.academies.R
import com.arifahmadalfian.academies.data.ContentEntity
import com.arifahmadalfian.academies.databinding.FragmentModuleContentBinding


class ModuleContentFragment : Fragment() {

    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val content = ContentEntity("<h3 class =\\\"fr-text-bordered\\\">Contoh Content</h3><p>Lorem ipsum dolor sit amet, consecterur adipiscing elit, sed do eiusmod tempor incidudunt ut labore et dolore magna aliqua. Ut enim ad minim vveniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea dommodo consequat. duis aute irure dolor in reprehenderi in voluptate velit esse cillum dolore eu fugiat nulla pariatur . Excepterur sint occaecat cupidatat non proident, sunt in culpa qui officia deseruuunt mollit anikm id est laborum .</p>")
            populateWebView(content)
        }
    }

    private fun populateWebView(content: ContentEntity) {
        fragmentModuleContentBinding.webView.loadData(content.content ?: "", "text/html", "UTF-8")
    }

}