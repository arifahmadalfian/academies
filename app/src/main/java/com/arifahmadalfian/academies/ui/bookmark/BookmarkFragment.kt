package com.arifahmadalfian.academies.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifahmadalfian.academies.R
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.databinding.FragmentBookmarkBinding
import com.arifahmadalfian.academies.utils.DataDummy
import com.arifahmadalfian.academies.viewmodel.ViewModelFactory

class BookmarkFragment : Fragment(), IBookmarkFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]
            val courses = viewModel.getBookmark()
            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with(fragmentBookmarkBinding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, course.title))
                .startChooser()
        }
    }
}