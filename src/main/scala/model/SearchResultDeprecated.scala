package model


object SearchResultDeprecated
{
//    implicit val actorEncoder : Encoder[Actor] = deriveEncoder[Actor]
//    implicit val actorsEncoder : Encoder[Option[List[Actor]]] = deriveEncoder[Option[List[Actor]]]
//    implicit val movieEncoder : Encoder[SearchResult] = deriveEncoder[SearchResult]
//    implicit val moviesEncoder : Encoder[Option[List[SearchResult]]] = deriveEncoder[Option[List[SearchResult]]]
//    implicit val moviesSearchTypeEncoder : Encoder[SearchType] = deriveEncoder[SearchType]
//    implicit val actorJobItemEncoder : Encoder[ActorJobItem] = deriveEncoder[ActorJobItem]
//    implicit val directorJobItemEncoder : Encoder[DirectorJobItem] = deriveEncoder[DirectorJobItem]
//    implicit val writerJobItemEncoder : Encoder[WriterJobItem] = deriveEncoder[WriterJobItem]
//    implicit val otherJobItemEncoder : Encoder[OtherJobItem] = deriveEncoder[OtherJobItem]
//    implicit val actorJobEncoder : Encoder[Job[ActorJobItem]] = deriveEncoder[Job[ActorJobItem]]
//    implicit val directorJobEncoder : Encoder[Job[DirectorJobItem]] = deriveEncoder[Job[DirectorJobItem]]
//    implicit val writerJobEncoder : Encoder[Job[WriterJobItem]] = deriveEncoder[Job[WriterJobItem]]
//    implicit val otherJobEncoder : Encoder[Job[OtherJobItem]] = deriveEncoder[Job[OtherJobItem]]
//    implicit val fullCastEncoder : Encoder[FullCast] = deriveEncoder[FullCast]
}
//case class SearchType(searchType : String, expression : String, results : List[SearchResult], errorMessage : String)
//case class MovieSearchType(searchType : String, expression : String, results : List[Title], errorMessage : String)

//case class SearchResult(id : String,
//    title : Option[String] = None,  // Name
//    resultType : Option[String] = None,
//    image : Option[String] = None,
//    description : Option[String] = None)

//case class Title(id : String,
//    title : Option[String] = None,  // Name
//    resultType : Option[String] = None,
//    image : Option[String] = None,
//    description : Option[String] = None,
//    Actors : Option[List[Actor]] = None,
//    rate : Option[String] = None,
//    releaseDate : Option[String] = None,
//    genres : Option[List[String]] = None)
//    extends IMovieData
//{
//    def getId() : String = id
//
//    println(s"TAMIR: movieID=$getId")
//}
//
//case class Actor(id : String,
//    title : Option[String] = None,  // Name
//    resultType : Option[String] = None,
//    image : Option[String] = None,
//    description : Option[String] = None,
//    movies : Option[List[SearchResult]] = None,
//    info : Option[String] = None)
//    extends IMovieData
//{
//    def getId() : String = id
//
//    println(s"TAMIR: ActorID: $getId")
//}
//
//case class ActorJobItem(id : String, name : Option[String], description : Option[String], image : Option[String], asCharacter : Option[String])
//
//case class DirectorJobItem(id : String, name : Option[String], description : Option[String], image : Option[String])
//
//case class WriterJobItem(id : String, name : Option[String], description : Option[String], image : Option[String])
//
//case class OtherJobItem(id : String, name : Option[String], description : Option[String], image : Option[String])
//
//case class Job[T](job : String, items : List[T])
//
//case class FullCast(imDbId : String,
//    title : String,
//    fullTitle : Option[String],
//    `type` : String,
//    year : String,
//    directors : Option[List[Job[DirectorJobItem]]],
//    writers : Option[List[Job[WriterJobItem]]],
//    actors : Option[List[Job[ActorJobItem]]],
//    others : Option[List[Job[OtherJobItem]]])
