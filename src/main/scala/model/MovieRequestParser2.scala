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
    implicit val movieEncoder : Encoder[CommonData] = deriveEncoder[CommonData]
    implicit val moviesEncoder : Encoder[Option[List[CommonData]]] = deriveEncoder[Option[List[CommonData]]]
    implicit val moviesSearchTypeEncoder : Encoder[SearchType] = deriveEncoder[SearchType]
    implicit val actorJobItemEncoder : Encoder[ActorJobItem] = deriveEncoder[ActorJobItem]
    implicit val directorJobItemEncoder : Encoder[DirectorJobItem] = deriveEncoder[DirectorJobItem]
    implicit val writerJobItemEncoder : Encoder[WriterJobItem] = deriveEncoder[WriterJobItem]
    implicit val otherJobItemEncoder : Encoder[OtherJobItem] = deriveEncoder[OtherJobItem]
    implicit val actorJobEncoder : Encoder[Job[ActorJobItem]] = deriveEncoder[Job[ActorJobItem]]
    implicit val directorJobEncoder : Encoder[Job[DirectorJobItem]] = deriveEncoder[Job[DirectorJobItem]]
    implicit val writerJobEncoder : Encoder[Job[WriterJobItem]] = deriveEncoder[Job[WriterJobItem]]
    implicit val otherJobEncoder : Encoder[Job[OtherJobItem]] = deriveEncoder[Job[OtherJobItem]]
    implicit val fullCastEncoder : Encoder[FullCast] = deriveEncoder[FullCast]
    
    def getMovies(http : HttpRequest) : Option[List[Movie]] =
    {
        val body = http.asString.body
        val parseResult = decode[MovieSearchType](body)
        val movies : Option[MovieSearchType] = parseResult match
        {
            case Right(moviesList) => Some(moviesList)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse movies: $error. t.getMovies(MovieRequestParser2.scala:38)")
                None
        }
        println(s"TAMIR: HERE: movies:${movies.toString}. t.getMovies(MovieRequestParser2.scala:46)")
        movies.map(_.results)
    }
    
    def getSeries(http : HttpRequest) : List[CommonData] =
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
