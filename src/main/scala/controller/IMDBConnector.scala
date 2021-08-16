package controller

import model.MovieRequestParser
import scalaj.http.{Http, HttpRequest}

class IMDBConnector(movieRequestParser : MovieRequestParser)
{
    val URL = "https://imdb-api.com/en/API/"
    val KEY = "k_skqcpywr"
    
    def searchTitle(movie : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchTitle/$KEY/$movie")

        val res = movieRequestParser.parseSearchTitleResult(http1)
    }

    def searchNames(actor : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchName/$KEY/$actor")

        val res = movieRequestParser.parseSearchNameResult(http1)
    }

    def searchActor(actorID : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchName/$KEY/$actorID")

        val res = movieRequestParser.parseSearchNameResult(http1)
    }

    def searchCast(movieID : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/FullCast/$KEY/$movieID")

        val res = movieRequestParser.searchCast(http1)
    }
    
    def getMovieInfo(movieID : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/Title/$KEY/$movieID")
    
        val res = movieRequestParser.getMovieInfo(http1)
    }
}
