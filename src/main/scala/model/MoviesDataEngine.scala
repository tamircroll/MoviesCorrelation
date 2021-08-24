package model

import java.awt.image.BufferedImage
import controller.IMDBConnector
import scala.collection.immutable
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.language.postfixOps

class MoviesDataEngine(imdbConnector : IMDBConnector)
{
    implicit val executionContext : ExecutionContext = ExecutionContext.global
    
    def searchTitle(title : String) =
    {
        imdbConnector.searchTitle(title)
    }
    
    def searchNames(name : String) =
    {
        imdbConnector.searchNames(name)
    }
    
    def searchActor(actorId : String) =
    {
        imdbConnector.searchActor(actorId)
    }
    
    def searchCast(movieID : String) : Option[List[ActorShort]] =
    {
        imdbConnector.searchCast(movieID)
    }
    
    def getMovieInfo(movieID : String) : Option[TitleData] =
    {
        imdbConnector.getMovieInfo(movieID)
    }
    
    def findSameMovies(actorID1 : String, actorID2 : String) : immutable.Seq[CastMovie] =
    {
        val actorListFuture1 = Future(searchActor(actorID1))
        val actorListFuture2 = Future(searchActor(actorID2))
        
        val moviesListOption1 : Option[List[CastMovie]] = Await.result(actorListFuture1.map(_.flatMap(_.getCastActors)), 10000 milli)
        val moviesListOption2 : Option[List[CastMovie]] = Await.result(actorListFuture2.map(_.flatMap(_.getCastActors)), 100000 milli)
        
        val res = (moviesListOption1, moviesListOption2) match
        {
            case (Some(moviesList1), Some(moviesList2)) => moviesList1.filter(movie => moviesList2.exists(_.id == movie.id))
            case _ => List()
        }
        println(s"TAMIR: HERE: res: $res\n. t.findSameMovies(Engine.scala:51)")
        res
    }
    
    def findSameActors(titleId1 : String, titleId2 : String) : List[ActorShort] =
    {
        val movieInfoFuture1 = Future(getMovieInfo(titleId1)).map(_.flatMap(_.actorList))
        val movieInfoFuture2 = Future(getMovieInfo(titleId2)).map(_.flatMap(_.actorList))
        
        val actorListOption1 = Await.result(movieInfoFuture1, 10000 milli)
        val actorListOption2 = Await.result(movieInfoFuture2, 100000 milli)
        
        val actorList = (actorListOption1, actorListOption2) match
        {
            case (Some(actorList1), Some(actorList2)) => actorList1.filter(movie => actorList2.exists(_.id == movie.id))
            case _ =>
            {
                println(s"TAMIR: ERROR: Failed to find actor List. t.findSameActors(Engine.scala:71)")
                List()
            }
        }
        
        println(s"TAMIR: HERE: Actors:$actorList\n$actorListOption1\n$actorListOption2. t.findSameActors(Engine.scala:72)")
        actorList
    }
    
    def getImage(imageUrl : String) : BufferedImage =
    {
        imdbConnector.getImage(imageUrl)
    }
}
