package model

import controller.IMDBConnector

class Engine(imdbConnector : IMDBConnector)
{
    def searchTitle(movieName : String)
    {
        imdbConnector.searchTitle(movieName)
        imdbConnector.searchNames(movieName)
    }
}
