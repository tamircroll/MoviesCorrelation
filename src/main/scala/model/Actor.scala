package model

case class Actor(val id : Option[String] = None,
            Name : Option[String] = None,
            movies : Option[List[Movie]] = None,
            info : Option[String] = None)
    extends IMovieData
{
    println(s"TMIAR: ID: $id")
}

