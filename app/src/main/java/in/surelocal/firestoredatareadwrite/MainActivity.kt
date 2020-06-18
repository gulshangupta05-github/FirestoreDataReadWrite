package `in`.surelocal.firestoredatareadwrite

import `in`.surelocal.firestoredatareadwrite.dataclass.UserInfo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.proto.TargetGlobal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var firestore: FirebaseFirestore
    var TAG = "mainactivty"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firestore = FirebaseFirestore.getInstance()

        senddata.setOnClickListener() {
            val sName = et_name.text.toString().trim()
            val sAddress = et_address.text.toString().trim()
            val sEmail = et_email.text.toString().trim()
            val sMobile = et_mobile.text.toString().trim()

            if (sName == "" || sAddress == "" || sEmail == "" || sMobile == "") {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            } else {
                val data =
                    UserInfo(name = sName, email = sEmail, address = sAddress, mobile = sMobile)
                firestore.collection("users").document().set(data)
                    .addOnCompleteListener() {
                        Log.d(TAG, "success")
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener() {
                        Log.d(TAG, "failed")
                    }
            }
            loaddata.setOnClickListener {
                intent = Intent(this, LoaddataActivity::class.java)
                startActivity(intent)
            }

        }


    }
}
