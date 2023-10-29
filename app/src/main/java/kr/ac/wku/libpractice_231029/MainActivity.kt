package kr.ac.wku.libpractice_231029

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.libpractice_231029.databinding.ActivityMainBinding
import kr.ac.wku.libpractice_231029.databinding.ActivityViewPhotoBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.imgProfile.setOnClickListener{
            //image view도 클릭이벤트를 지원
            val myIntent = Intent(this, view_photo::class.java)
            startActivity(myIntent)

        }

        binding.btnCall.setOnClickListener {
            val myUri = Uri.parse("tel:010-1234-1234")

            val myIntent = Intent(Intent.ACTION_CALL)
        }
    }
}