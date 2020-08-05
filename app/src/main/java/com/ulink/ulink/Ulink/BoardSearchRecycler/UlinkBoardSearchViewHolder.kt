package com.ulink.ulink.Ulink.UlinkClassBoardRecycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulink.ulink.R
import com.ulink.ulink.Ulink.BoardData

class UlinkBoardSearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val tv_nickname : TextView = itemView.findViewById(R.id.tv_nickname)
    val tv_time : TextView = itemView.findViewById(R.id.tv_time)
    val tv_content : TextView = itemView.findViewById(R.id.tv_content)
   // val btn_heart : ImageButton = itemView.findViewById(R.id.btn_heart)
    val tv_comment_count : TextView = itemView.findViewById(R.id.tv_comment_count)
    val tv_heart_count : TextView = itemView.findViewById(R.id.tv_heart_count)

    fun bind(BoardData: BoardData){
        tv_nickname.text = BoardData.nickname
        tv_time.text = BoardData.createdAt
        tv_content.text = BoardData.content
        tv_comment_count.text = BoardData.commentCount.toString()
        tv_heart_count.text = BoardData.likeCount.toString()
    }

}
