package model

import controller.IMDBConnector
import scala.collection.immutable
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.language.postfixOps

class Engine(imdbConnector : IMDBConnector)
{
    implicit val executionContext : ExecutionContext = ExecutionContext.global
    
    val roleActorSet = Set("Actress", "Actor")
    
    def searchTitle(title : String) =
    {
        imdbConnector.searchTitle(title)
    }
    
    def searchNames(name : String)
    {
        imdbConnector.searchNames(name)
    }
    
    def searchActor(actorId : String) =
    {
        imdbConnector.searchActor(actorId)
    }
    
    def searchCast(movieID : String)
    {
        imdbConnector.searchCast(movieID)
    }
    
    def findSameMovies(actorID1 : String, actorID2 : String) : immutable.Seq[CastMovie] =
    {
        val future1 = Future(searchActor(actorID1))
        val future2 = Future(searchActor(actorID2))
        
        val actor1 : NameData = Await.result(future1.map(_.head), 10000 milli)
        val actor2 : NameData = Await.result(future2.map(_.head), 100000 milli)
    
        val res = actor1.castMovies.getOrElse(List())
            .filter(_.role.forall(roleActorSet.contains))
            .filter(movie =>
                actor2.castMovies.getOrElse(List())
                    .filter(_.role.forall(roleActorSet.contains))
                    .exists(_.id == movie.id))
        
        println(s"TAMIR: HERE: res: $res\n. t.findSameMovies(Engine.scala:51)")
        res
    }
}
