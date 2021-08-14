import controller.{IMDBConnector, IMDBConnector2}
import scalaj.http.Http

object Main
{
    def main(args : Array[String]) : Unit =
    {
//        Temp.fun()
        
        println("MoviesCorrelation is on")
        IMDBConnector2.getMovie("Rambo")
//        IMDBConnector.getActors("")
    }
}