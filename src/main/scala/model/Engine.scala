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
        val future1 = Future(searchActor(actorID1))
        val future2 = Future(searchActor(actorID2))
        
        val actor1 : NameData = Await.result(future1.map(_.head), 10000 milli)
        val actor2 : NameData = Await.result(future2.map(_.head), 100000 milli)
        
        // Get movies and keep only roles of actor/Actress
        val actorCastMovies = actor1.castMovies.getOrElse(List()).filter(_.role.forall(roleActorSet.contains))
        val actor2CastMovies = actor2.castMovies.getOrElse(List()).filter(_.role.forall(roleActorSet.contains))
        
        val res = actorCastMovies.filter(movie => actor2CastMovies.exists(_.id == movie.id))
        println(s"TAMIR: HERE: res: $res\n. t.findSameMovies(Engine.scala:51)")
        res
    }
    
    def findSameActors(titleId1 : String, titleId2 : String) : List[ActorShort] =
    {
        val future1 = Future(getMovieInfo(titleId1))
        val future2 = Future(getMovieInfo(titleId2))
        
        val actorListOption1 = Await.result(future1.map(_.flatMap(_.actorList)), 10000 milli)
        val actorListOption2 = Await.result(future2.map(_.flatMap(_.actorList)), 100000 milli)

        val actorList1 = actorListOption1.getOrElse(List())
        val actorList2 = actorListOption2.getOrElse(List())
        
        val res = actorList1.filter(actor => actorList2.exists(_.id == actor.id))
        println(s"TAMIR: HERE: Actors:$res. t.findSameActors(Engine.scala:72)")
        res
    }
}
