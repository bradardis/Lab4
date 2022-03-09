package edu.temple.lab4mobileappdevelopment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class recAdapter( private val picsList : ArrayList<pics>) : RecyclerView.Adapter<recAdapter.MyViewHolder>(){


    private lateinit var myListener : onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        myListener = listener

    }



    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val image : ShapeableImageView = itemView.findViewById(R.id.image)
        val desc : TextView = itemView.findViewById(R.id.desc)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = picsList[position]
        holder.image.setImageResource(currentItem.image)
        holder.desc.text = currentItem.desc
    }

    override fun getItemCount(): Int {
        return picsList.size
    }


}