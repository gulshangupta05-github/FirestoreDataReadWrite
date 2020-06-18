package `in`.surelocal.firestoredatareadwrite.myadapter

import `in`.surelocal.firestoredatareadwrite.R
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VierwHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName =itemView. findViewById<TextView>(R.id.tvName)
}
