package com.glowroad.tabshreya

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {
    private var mCommonPagerAdapter: ViewPagerAdapter? = null
    private var mProductDescriptionFragment: ProductDescriptionFragment? = null
    private var mProductDetailFragment: ProductDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        mCommonPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        mProductDescriptionFragment= ProductDescriptionFragment()
        mProductDetailFragment= ProductDetailFragment()
        mProductDescriptionFragment?.let { mCommonPagerAdapter?.addFrag(it, "Tentang Promo") }
        mProductDetailFragment?.let { mCommonPagerAdapter?.addFrag(it, "Syarat Promo") }
        hotelSpeciality.setupWithViewPager(vp)
        vp.adapter = mCommonPagerAdapter
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        private val mFragmentList by lazy { mutableListOf<Fragment>() }
        private val mFragmentTitleList by lazy { mutableListOf<String>() }
        private var mCurrentPosition = -1

        override fun getItem(position: Int): Fragment = mFragmentList[position]

        override fun getCount(): Int = mFragmentList.size

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence = mFragmentTitleList[position]

        override fun setPrimaryItem(container: ViewGroup, position: Int, any: Any) {
            super.setPrimaryItem(container, position, any)
            if (position != mCurrentPosition) {
                val fragment = any as? Fragment
                val pager = container as CustomPager?
                fragment?.view?.let {
                    mCurrentPosition = position
                    pager?.measureCurrentView(fragment.view)
                }
            }
        }

    }
}
