import controller.IMDBConnector
import model.{Engine, MovieRequestParser}

object Main
{
    def main(args : Array[String]) : Unit =
    {
        println("MoviesCorrelation is on")
        val connector = new IMDBConnector(new MovieRequestParser())
        val imdbEngine = new Engine(connector)
        connector.searchTitle("The Matrix")
        connector.searchNames("angelina")
        connector.searchCast("tt1375666")
        connector.getMovieInfo("tt1375666")
        imdbEngine.findSameMovies("nm0001401", "nm0000093")
        imdbEngine.findSameActors("tt1375666", "tt0110413")
    }
}