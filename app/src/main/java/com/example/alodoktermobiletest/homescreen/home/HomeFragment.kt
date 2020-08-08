package com.example.alodoktermobiletest.homescreen.home

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.databinding.HomeFragmentBinding
import com.example.alodoktermobiletest.homescreen.home.detail.DetailHomeActivity
import com.example.alodoktermobiletest.data.model.ImageCard
import com.example.alodoktermobiletest.utils.Statics

class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {

    private lateinit var homeAdapter: HomeAdapter
    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.fillList()
        homeAdapter = HomeAdapter(context, viewModel.list, this)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
    }

    override fun onClick(model: ImageCard) {
        val intent = Intent(activity, DetailHomeActivity::class.java)
        intent.putExtra(Statics.Extras.DETAIL_HOME_EXTRA, model)
        startActivity(intent)
    }
}