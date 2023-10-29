package kr.ac.wku.libpractice_231029

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gun0912.tedpermission.PermissionListener
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
            //권한 획득 성공 여부에 따른 행동 지침을 변수에 저장(인터페이스-> 객체화 : 익명클래스 활용)
            val pl = object : PermissionListener{
                override fun onPermissionGranted() {
                    Toast.makeText(this@MainActivity, "권한 문제로 전화 연결이 안됩니다.", Toast.LENGTH_SHORT).show()
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                }

            }

            val myUri = Uri.parse("tel:010-1234-1234")

            val myIntent = Intent(Intent.ACTION_CALL)
        }
    }
}