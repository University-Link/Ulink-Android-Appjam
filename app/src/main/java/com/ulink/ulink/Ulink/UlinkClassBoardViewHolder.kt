package com.ulink.ulink.Ulink

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulink.ulink.R
import com.ulink.ulink.Ulink.BoardData

class UlinkClassBoardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val tv_nickname : TextView = itemView.findViewById(R.id.tv_nickname)
    val tv_time : TextView = itemView.findViewById(R.id.tv_time)
    val tv_content : TextView = itemView.findViewById(R.id.tv_content)
    val tv_comment_count : TextView = itemView.findViewById(R.id.tv_comment_count)
    val tv_heart_count : TextView = itemView.findViewById(R.id.tv_heart_count)
    //val img_tag : ImageView = itemView.findViewById(R.id.img_uni_tag)
    //val btn_heart : ImageButton = itemView.findViewById(R.id.btn_heart)

    fun bind(BoardData: BoardData){
        tv_nickname.text = BoardData.nickname
        tv_time.text = BoardData.createdAt
        tv_content.text = BoardData.content
        tv_comment_count.text = "댓글 "+BoardData.commentCount
        tv_heart_count.text = BoardData.likeCount.toString()
    }

}

