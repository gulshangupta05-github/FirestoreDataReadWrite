package `in`.surelocal.firestoredatareadwrite

import `in`.surelocal.firestoredatareadwrite.dataclass.UserInfo
import `in`.surelocal.firestoredatareadwrite.myadapter.MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_loaddata.*
import kotlinx.android.synthetic.main.activity_main.*

class LoaddataActivity : AppCompatActivity() {

    private var mDatas = ArrayList<UserInfo>()
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loaddata)
        firestore = FirebaseFirestore.getInstance()

        firestore = FirebaseFirestore.getInstance()
        firestore.collection("users").get()
            .addOnSuccessListener { document ->

                val data = document.toObjects(UserInfo::class.java)
                storeData(data)   ///   yha storeData name ka ek metod bna hai
            }
    }


    private fun storeData(data: List<UserInfo>) {
        for (i in data) {
            mDatas.add(i)
        }
        recyclerview.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        recyclerview.adapter = MyAdapter(this, mDatas)
    }
}

