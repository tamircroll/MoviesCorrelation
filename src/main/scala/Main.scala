import controller.IMDBConnector
import model.MovieRequestParser
import scalaj.http.Http

object Main
{
    def main(args : Array[String]) : Unit =
    {
//        Temp.fun()
        
        println("MoviesCorrelation is on")
        new IMDBConnector(new MovieRequestParser()).getMovie("Rambo")
//        IMDBConnector.getActors("")
    }
}