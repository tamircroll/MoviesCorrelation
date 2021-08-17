package controller

import model.{ActorShort, MovieRequestParser, NameData, SearchResult, TitleData}
import scalaj.http.{Http, HttpRequest}

class IMDBConnector(movieRequestParser : MovieRequestParser)
{
    val URL = "https://imdb-api.com/en/API/"
    val KEY = "k_skqcpywr"
    
    def searchTitle(movie : String) : Option[List[SearchResult]] =
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchTitle/$KEY/$movie")
        movieRequestParser.parseSearchTitleResult(http1)
    }
    
    def searchNames(actor : String) : Option[List[SearchResult]] =
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchName/$KEY/$actor")
        movieRequestParser.parseSearchNamesResult(http1)
    }
    
    def searchActor(actorID : String) : Option[NameData] =
    {
        val http1 : HttpRequest = Http(s"${URL}/Name/$KEY/$actorID")
        movieRequestParser.parseSearchNameResult(http1)
    }
    
    def searchCast(movieID : String) : Option[List[ActorShort]] =
    {
        val http1 : HttpRequest = Http(s"${URL}/FullCast/$KEY/$movieID")
        movieRequestParser.searchCast(http1)
    }
    
    def getMovieInfo(movieID : String) : Option[TitleData] =
    {
        val http1 : HttpRequest = Http(s"${URL}/Title/$KEY/$movieID")
        movieRequestParser.getMovieInfo(http1)
    }
}
