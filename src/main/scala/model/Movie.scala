package model

case class Movie(ID : Option[String] = None,
            name : Option[String] = None,
            Actors : Option[List[Actor]] = None,
            description : Option[String] = None,
            rate : Option[String] = None,
            releaseDate : Option[String] = None,
            genres : Option[List[String]] = None)
    extends IMovieData
{
    
    println(s"TAMIR: HERE: Creates movie. ID=$ID. t.Movie(Movie.scala:13)")
}
