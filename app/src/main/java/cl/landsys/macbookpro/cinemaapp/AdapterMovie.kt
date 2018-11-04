package cl.landsys.macbookpro.cinemaapp

import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.ArrayList

class AdapterMovie(var list:ArrayList<Movie>):RecyclerView.Adapter<AdapterMovie.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_item_movie,parent,false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(list[p1])
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bindItems(data:Movie){
            val title:TextView=itemView.findViewById(R.id.movie_titulo)
            val duration:TextView=itemView.findViewById(R.id.movie_duracion)
            val category:TextView=itemView.findViewById(R.id.movie_clasificacion)
            val thumbnail:ImageView=itemView.findViewById(R.id.movie_img)
            val date:TextView=itemView.findViewById(R.id.movie_horario)

            title.text=data.title
            duration.text=data.duration.toString()
            category.text=data.category
            Glide.with(itemView.context).load(data.thumbnail).into(thumbnail)
            date.text=data.date
        }
    }

}