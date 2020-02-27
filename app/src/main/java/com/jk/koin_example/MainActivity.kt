package com.jk.koin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jk.koin_example.fragment.PostOfficeInfoFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

  private val postOfficeInfoFragment: PostOfficeInfoFragment by inject()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    supportFragmentManager.beginTransaction().replace(R.id.root, postOfficeInfoFragment, "postOfficeInfo").commit()
  }

  override fun onResume() {
    super.onResume()

  }

  fun search(view: View) {

  }
}
