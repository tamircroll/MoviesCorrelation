import controller.IMDBConnector
import model.{Engine, MovieRequestParser}
import scalaj.http.Http

object Main
{
    def main(args : Array[String]) : Unit =
    {
//        Temp.fun()
        
        println("MoviesCorrelation is on")
        val imdbEngine = new Engine(new IMDBConnector(new MovieRequestParser()))
        imdbEngine.searchMovie("Rambo")
//        IMDBConnector.getActors("")
    }
}