package model

case class SearchType(searchType : String, expression : String, results : List[CommonData], errorMessage : String)
case class MovieSearchType(searchType : String, expression : String, results : List[Movie], errorMessage : String)

case class CommonData(id : String,
    title : Option[String] = None,  // Name
    resultType : Option[String] = None,
    image : Option[String] = None,
    description : Option[String] = None)

case class Movie(id : String,
    title : Option[String] = None,  // Name
    resultType : Option[String] = None,
    image : Option[String] = None,
    description : Option[String] = None,
    Actors : Option[List[Actor]] = None,
    rate : Option[String] = None,
    releaseDate : Option[String] = None,
    genres : Option[List[String]] = None)
    extends IMovieData
{
    def getId() : String = id
    
    println(s"TAMIR: movieID=$getId")
}

case class Actor(id : String,
    title : Option[String] = None,  // Name
    resultType : Option[String] = None,
    image : Option[String] = None,
    description : Option[String] = None,
    movies : Option[List[CommonData]] = None,
    info : Option[String] = None)
    extends IMovieData
{
    def getId() : String = id
    
    println(s"TAMIR: ActorID: $getId")
}

case class ActorJobItem(id : String, name : Option[String], description : Option[String], image : Option[String], asCharacter : Option[String])

case class DirectorJobItem(id : String, name : Option[String], description : Option[String], image : Option[String])

case class WriterJobItem(id : String, name : Option[String], description : Option[String], image : Option[String])

case class OtherJobItem(id : String, name : Option[String], description : Option[String], image : Option[String])

case class Job[T](job : String, items : List[T])

case class FullCast(imDbId : String,
    title : String,
    fullTitle : String,
    `type` : String,
    year : String,
    directors : Option[List[Job[DirectorJobItem]]],
    writers : Option[List[Job[WriterJobItem]]],
    actors : Option[List[Job[ActorJobItem]]],
    others : Option[List[Job[OtherJobItem]]])
