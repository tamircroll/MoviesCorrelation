package model


import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto.deriveEncoder
import io.circe.parser._
import scalaj.http.HttpRequest


object MovieRequestParser2
{
    val RESULTS = "results"
    val ID = "id"
    val IMAGE = "image"
    val HEIGHT = "height"
    val URL = "url"
    val NAME = "name"
    val MOVIE_TITLE = "l"
    val KNOWN_FOR = "knownFor"
    val ACTOR_ID_PREFIX = """/name/"""
    val MOVIE_ID_PREFIX = """/title/"""
    val STARS = "s"
    val TITLE_TYPE = "q"  // TV series/TV movie...
    
    implicit val actorEncoder : Encoder[Actor] = deriveEncoder[Actor]
    implicit val actorsEncoder : Encoder[Option[List[Actor]]] = deriveEncoder[Option[List[Actor]]]
    implicit val movieEncoder : Encoder[Movie] = deriveEncoder[Movie]
    implicit val moviesEncoder : Encoder[Option[List[Movie]]] = deriveEncoder[Option[List[Movie]]]
    implicit val moviesSearchTypeEncoder : Encoder[SearchType] = deriveEncoder[SearchType]
    
    
    def getMovies(http : HttpRequest) : Option[List[Movie]] =
    {
        val body = http.asString.body
        println(s"TAMIR: HERE: body: $body")
        val parseResult = decode[SearchType](body)
        val movies : Option[SearchType] = parseResult match
        {
            case Right(moviesList) => Some(moviesList)
            case Left(error) => {
                println(s"TAMIR: HERE: failed to parse movies: $error. t.getMovies(MovieRequestParser2.scala:38)")
                None
            }
        }
        movies.flatMap(_.results)
    }
    
    def getSeries(http : HttpRequest) : List[Movie] =
    {
        ???
    }
    
    def getActors(res : HttpRequest) : List[Actor] =
    {
        ???
    }
    
    def getMovieInfo(movieId : HttpRequest)
    {
        ???
    }
}
