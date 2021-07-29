package model

case class Actor(ID : Option[String] = None,
            Name : Option[String] = None,
            movies : Option[List[Movie]] = None,
            info : Option[String] = None)
    extends IMovieData
{
    val m_ID = ID
    println(s"TMIAR: ID: $ID")
}

