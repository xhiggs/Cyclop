package com.redbreadplease.cyclop.activities

import android.os.Bundle
import com.redbreadplease.cyclop.R
import com.redbreadplease.cyclop.activities.abstracts.RecyclableNewsActivity
import com.redbreadplease.cyclop.activities.enums.ButtonsPurposes.NEWS

class NewsActivity : RecyclableNewsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setContentSpaceAndNavbar(NEWS)
        refreshContent()
    }

    override fun refreshContent() {
        tryToShowNews()
    }
}