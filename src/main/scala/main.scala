import View.MainView
import controller.IMDBConnector
import model.{MoviesDataEngine, MovieRequestParser}

object main
{
    def main(args : Array[String]) : Unit =
    {
        println("MoviesCorrelation is on")
        val connector = new IMDBConnector(new MovieRequestParser())
        val imdbEngine = new MoviesDataEngine(connector)
//        imdbEngine.searchTitle("The Matrix")
//        imdbEngine.searchNames("angelina")
//        imdbEngine.searchCast("tt1375666")
//        imdbEngine.getMovieInfo("tt0133093")
//        imdbEngine.findSameMovies("nm0000206", "nm0005251")
//        imdbEngine.findSameActors("tt1375666", "tt0110413")
        new MainView(imdbEngine)
    }
}