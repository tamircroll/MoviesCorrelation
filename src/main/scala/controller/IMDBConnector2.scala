package controller

import model.MovieRequestParser2
import scalaj.http.{Http, HttpRequest}

object IMDBConnector2
{
    val URL = "https://imdb-api.com/en/API/"
    val KEY = "k_skqcpywr"

    def getMovie(movie : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchMovie/$KEY/$movie")

        val res = MovieRequestParser2.getMovies(http1)
    }
    
    def getSeries(series : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchSeries/$KEY/$series")

        val res = MovieRequestParser2.getSeries(http1)
    }

    def getActor(actor : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchName/$KEY/$actor")

        val res = MovieRequestParser2.getActors(http1)
    }

    def getCast(movieID : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/FullCast/$KEY/$movieID")

        val res = MovieRequestParser2.getActors(http1)
    }
    
    def getMovieInfo(movieID : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/Title/$KEY/$movieID")
    
        val res = MovieRequestParser2.getMovieInfo(http1)
    }
}
