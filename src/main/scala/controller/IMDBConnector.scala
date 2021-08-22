package controller

import model.{ActorShort, MovieRequestParser, NameData, SearchResult, TitleData}
import scalaj.http.{Http, HttpRequest}

class IMDBConnector(movieRequestParser : MovieRequestParser)
{
    val URL = "https://imdb-api.com/en/API/"
    val KEY = "k_skqcpywr"
    
    def searchTitle(movie : String) : Option[List[SearchResult]] =
    {
        val formattedMovie = movie.replaceAll(" ", "%20")
        val http1 : HttpRequest = Http(createURL("SearchTitle", formattedMovie))
        movieRequestParser.parseSearchTitleResult(http1)
    }
    
    def searchNames(actor : String) : Option[List[SearchResult]] =
    {
        val formattedActor = actor.replaceAll(" ", "%20")
        val http1 : HttpRequest = Http(createURL("SearchName", formattedActor))
        movieRequestParser.parseSearchNamesResult(http1)
    }
    
    def searchActor(actorID : String) : Option[NameData] =
    {
        val http1 : HttpRequest = Http(createURL("Name", actorID))
        movieRequestParser.parseSearchNameResult(http1)
    }
    
    def searchCast(movieID : String) : Option[List[ActorShort]] =
    {
        val http1 : HttpRequest = Http(createURL("FullCast", movieID))
        movieRequestParser.searchCast(http1)
    }
    
    def getMovieInfo(movieID : String) : Option[TitleData] =
    {
        val http1 : HttpRequest = Http(createURL("Title", movieID))
        movieRequestParser.getMovieInfo(http1)
    }
    
    private def createURL(requestData : String, requestType : String) : String =
    {
        s"$requestData/$KEY/$requestType"
    }
}
