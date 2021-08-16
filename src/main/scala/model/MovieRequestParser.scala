package model


import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto.deriveEncoder
import io.circe.parser._
import scalaj.http.HttpRequest

class MovieRequestParser
{
    def searchTitle(http : HttpRequest) : Option[List[SearchResult]] =
    {
        val body = http.asString.body
        val parseResult = decode[SearchData](body)
        val movies : Option[SearchData] = parseResult match
        {
            case Right(titlesList) => Some(titlesList)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse movies:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:21)")
                None
        }
        println(s"TAMIR: HERE: Succeeded to parse movies, . t.searchTitle(MovieRequestParser.scala:23)\n body:$body\n")
        println(s"TAMIR: HERE: movies:${movies.toString}. t.getMovies(MovieRequestParser.scala:24)")
        movies.flatMap(_.results)
    }
    
    def searchActors(http : HttpRequest) : List[SearchResult] =
    {
        ???
    }
    
    def searchCast(http : HttpRequest) = ???
    
    def getMovieInfo(http : HttpRequest)
    {
        ???
    }
    
    
//    def searchMovie(http : HttpRequest) : Option[List[Movie]] =
//    {
//        val body = http.asString.body
//        val parseResult = decode[MovieSearchType](body)
//        val movies : Option[MovieSearchType] = parseResult match
//        {
//            case Right(moviesList) => Some(moviesList)
//            case Left(error) =>
//                println(s"TAMIR: HERE: failed to parse movies:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:38)")
//                None
//        }
//        println(s"TAMIR: HERE: movies:${movies.toString}. t.getMovies(MovieRequestParser.scala:46)")
//        movies.map(_.results)
//    }
//
//    def searchSeries(http : HttpRequest) : Option[List[Movie]] =
//    {
//        val body = http.asString.body
//        val parseResult = decode[MovieSearchType](body)
//        val movies : Option[MovieSearchType] = parseResult match
//        {
//            case Right(moviesList) => Some(moviesList)
//            case Left(error) =>
//                println(s"TAMIR: HERE: failed to parse movies: $error. t.getMovies(MovieRequestParser.scala:38)")
//                None
//        }
//        println(s"TAMIR: HERE: movies:${movies.toString}. t.getMovies(MovieRequestParser.scala:46)")
//        movies.map(_.results)
//    }

}
