package `in`.surelocal.firestoredatareadwrite.myadapter

import `in`.surelocal.firestoredatareadwrite.LoaddataActivity
import `in`.surelocal.firestoredatareadwrite.R
import `in`.surelocal.firestoredatareadwrite.dataclass.UserInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( loaddataActivity: LoaddataActivity, val mDatas:ArrayList<UserInfo>):RecyclerView.Adapter<VierwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VierwHolder {
        return VierwHolder(LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false))
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }


     override fun onBindViewHolder(holder: VierwHolder, position: Int) {
         holder.tvName.text = mDatas[position].name
     }


 }

