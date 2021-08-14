package model

case class SearchType(searchType : String, expression : String, results : Option[List[Movie]], errorMessage : String)

//case class MovieList(results : List[Movie])

case class Movie(id : String,
    resultType : Option[String] = None,
    image : Option[String] = None,
    title : Option[String] = None,  // Name
    description : Option[String] = None,
    Actors : Option[List[Actor]] = None,
    rate : Option[String] = None,
    releaseDate : Option[String] = None,
    genres : Option[List[String]] = None)
    extends IMovieData
{
    println(s"TAMIR: HERE: Creates movie. ID=$id. t.Movie(Movie.scala:13)")
}