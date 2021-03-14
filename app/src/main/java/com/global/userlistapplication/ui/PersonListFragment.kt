package com.global.userlistapplication.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.global.userlistapplication.R
import com.global.userlistapplication.common.EndlessScrollListener
import com.global.userlistapplication.databinding.FragmentUserListBinding
import com.global.userlistapplication.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PersonListFragment : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var personListAdapter: PersonListAdapter

    private lateinit var personListViewModel: PersonListViewModel

    private lateinit var binding: FragmentUserListBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        binding.viewState = personListViewModel.status.value

        initRecyclerView()
        setupObservers()

        personListViewModel.fetchPersonList()

    }

    private fun initViewModel() {
        personListViewModel =
            ViewModelProvider(this, viewModelFactory)
                .get(PersonListViewModel::class.java)
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)

        binding.rvRecycler.apply {
            adapter = personListAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(object : EndlessScrollListener(linearLayoutManager) {
                override fun onLoadMore() {
                    fetchPersonList()
                }
            })
        }
    }

    private fun setupObservers() {
        personListViewModel.personListLD.observe(viewLifecycleOwner, Observer {
            personListAdapter.submitList(it)
            personListAdapter.notifyDataSetChanged()
            binding.swipeRefresh.isRefreshing = false
            binding.noDataPage.isVisible = it.isEmpty()
            binding.rvRecycler.smoothScrollBy(0, 60)
        })

        personListViewModel.status.observe(viewLifecycleOwner, Observer {
            binding.viewState = it
            binding.executePendingBindings()
        })

        binding.icRefresh.setOnClickListener {
            run {
                fetchPersonList()
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            reset()
            fetchPersonList()
        }

    }

    private fun fetchPersonList() {
        personListViewModel.fetchPersonList()
    }

    private fun reset() {
        personListViewModel.reset()
    }
}