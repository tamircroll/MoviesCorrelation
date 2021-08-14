package controller

import controller.IMDBConnector.{KEY, RAPIDAPI_HOST, X_RAPIDAPI_HOST, X_RAPIDAPI_KEY}
import model.MovieRequestParser
import scalaj.http.{Http, HttpRequest}

object IMDBConnector2
{
    val URL = "https://imdb-api.com/en/API/"
    val KEY = "k_skqcpywr"

    def getMovie(movie : String)
    {
        val http1 : HttpRequest = Http(s"${URL}/SearchMovie/$KEY/$movie")
            .header(X_RAPIDAPI_KEY, KEY)
            .header(X_RAPIDAPI_HOST, RAPIDAPI_HOST)

        val res = MovieRequestParser.getActors(http1)
    }
    
    
}
