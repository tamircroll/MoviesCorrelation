import controller.IMDBConnector
import scalaj.http.Http

object Main
{
    def main(args : Array[String]) : Unit =
    {
//        Temp.fun()
        
        println("MoviesCorrelation is on")
        IMDBConnector.getActors("")
    }
}