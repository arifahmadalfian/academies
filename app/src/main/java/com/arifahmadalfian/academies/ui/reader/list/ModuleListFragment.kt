package com.arifahmadalfian.academies.ui.reader.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifahmadalfian.academies.data.source.local.entity.ModuleEntity
import com.arifahmadalfian.academies.databinding.FragmentModuleListBinding
import com.arifahmadalfian.academies.ui.reader.CourseReaderActivity
import com.arifahmadalfian.academies.ui.reader.CourseReaderViewModel
import com.arifahmadalfian.academies.ui.reader.ICourseReaderCallback
import com.arifahmadalfian.academies.viewmodel.ViewModelFactory
import com.arifahmadalfian.academies.vo.Status

class ModuleListFragment : Fragment(), IMyAdapterClickListener {

    companion object {
        val TAG: String = ModuleListFragment::class.java.simpleName
        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }
    private lateinit var viewModel: CourseReaderViewModel

    private var fragmentModuleListBinding: FragmentModuleListBinding? = null
    private val binding = fragmentModuleListBinding
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: ICourseReaderCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentModuleListBinding = FragmentModuleListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]
        adapter = ModuleListAdapter(this)

        viewModel.modules.observe(this, { moduleEntities ->
            if (moduleEntities != null) {
                when (moduleEntities.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        populateRecyclerView(moduleEntities.data as List<ModuleEntity>)
                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        with(binding) {
            this?.progressBar?.visibility = View.GONE
            adapter.setModules(modules)
            this?.rvModule?.layoutManager = LinearLayoutManager(context)
            this?.rvModule?.setHasFixedSize(true)
            this?.rvModule?.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            this?.rvModule?.addItemDecoration(dividerItemDecoration)
        }
    }

}