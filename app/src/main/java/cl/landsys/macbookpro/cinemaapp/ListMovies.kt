package cl.landsys.macbookpro.cinemaapp


class ListMovies:ArrayList<Movie>(){

    fun addMovie(movie: Movie){
        this.add(movie)
    }

    fun seachMovie(title:String):Movie?{
        this.forEach(){
            if(it.title.equals(title)){
                return it
            }
        }
        return null
    }

    fun deleteMovie(title:String):String{
        if(seachMovie(title)!=null){
            this.remove(seachMovie(title))
            return "Pelicula Eliminada Correctamente!"
        }else{
            return "La Pelicula a Eliminar no Existe!"
        }
    }
}