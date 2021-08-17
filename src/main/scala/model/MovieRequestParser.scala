package model


import io.circe.generic.auto._
import io.circe.parser._
import scalaj.http.HttpRequest

class MovieRequestParser
{
    def parseSearchTitleResult(http : HttpRequest) : Option[List[SearchResult]] =
    {
        val body = http.asString.body
        val parseResult = decode[SearchData](body)
        val movies : Option[SearchData] = parseResult match
        {
            case Right(titlesList) => Some(titlesList)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse movies:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:${Thread.currentThread().getStackTrace()(2).getLineNumber()})")
                None
        }
        println(s"TAMIR: HERE: movies:${movies.toString}. t.getMovies(MovieRequestParser.scala:21)")
        movies.flatMap(_.results)
    }
    
    def parseSearchNamesResult(http : HttpRequest) : Option[List[SearchResult]] =
    {
        val body = http.asString.body
        val parseResult = decode[SearchData](body)
        val actors : Option[SearchData] = parseResult match
        {
            case Right(actorsList) => Some(actorsList)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse actors:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:35)")
                None
        }
        println(s"TAMIR: HERE: actors:${actors.toString}. t.getMovies(MovieRequestParser.scala:35)")
        actors.flatMap(_.results)
    }
    
    def parseSearchNameResult(http : HttpRequest) : Option[NameData] =
    {
        val body = http.asString.body
        val parseResult = decode[NameData](body)
        val actor : Option[NameData] = parseResult match
        {
            case Right(actorsList) => Some(actorsList)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse actor:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:35)")
                None
        }
        println(s"TAMIR: HERE: actor:${actor.toString}. t.getMovies(MovieRequestParser.scala:35)")
        actor
    }
    
    def searchCast(http : HttpRequest) : Option[List[ActorShort]] =
    {
        val body = http.asString.body
        val parseResult = decode[FullCastData](body)
        val cast : Option[FullCastData] = parseResult match
        {
            case Right(fullCast) => Some(fullCast)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse cast:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:35)")
                None
        }
        println(s"TAMIR: HERE: cast:${cast.toString}. t.getMovies(MovieRequestParser.scala:35)")
        cast.flatMap(_.actors)
    }
    
    def getMovieInfo(http : HttpRequest) : Option[TitleData] =
    {
        val body = http.asString.body
        val parseResult = decode[TitleData](body)
        val movieInfo : Option[TitleData] = parseResult match
        {
            case Right(info) => Some(info)
            case Left(error) =>
                println(s"TAMIR: HERE: failed to parse movieInfo:\n body:$body\n error: $error. t.getMovies(MovieRequestParser.scala:35)")
                None
        }
        println(s"TAMIR: HERE: movieInfo:${movieInfo.toString}. t.getMovies(MovieRequestParser.scala:35)")
        movieInfo
    }
}
