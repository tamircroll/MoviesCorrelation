package model

import controller.IMDBConnector

class Engine(imdbConnector : IMDBConnector)
{
    def searchMovie(movieName : String)
    {
        imdbConnector.searchTitle(movieName)
    }
}
