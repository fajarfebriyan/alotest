package com.example.alodoktermobiletest.homescreen.home.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.databinding.ActivityDetailHomeBinding
import com.example.alodoktermobiletest.data.model.ImageCard
import com.example.alodoktermobiletest.utils.Statics
import kotlinx.android.synthetic.main.layout_appbar.*
import ss.com.bannerslider.Slider
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class DetailHomeActivity : AppCompatActivity() {

    private var imageCard: ImageCard? = null
    private lateinit var binding: ActivityDetailHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_home)

        binding.appBarLayout.tvTitle.text = getString(R.string.app_name)

        setSupportActionBar(binding.appBarLayout.toolbar)
        supportActionBar?.also {
            it.setHomeButtonEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }

        val bundle = intent.extras
        imageCard = bundle?.getParcelable(Statics.Extras.DETAIL_HOME_EXTRA)

        Slider.init(DetailImageLoadingService())
        binding.bsDetail.setAdapter(ImageSliderAdapter())
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    inner class ImageSliderAdapter: SliderAdapter() {
        override fun getItemCount(): Int {
            return imageCard?.imageList?.size?: 0
        }

        override fun onBindImageSlide(position: Int, viewHolder: ImageSlideViewHolder) {
            imageCard?.imageList?.let {
                viewHolder.bindImageSlide(it[position])
            }
        }
    }
}