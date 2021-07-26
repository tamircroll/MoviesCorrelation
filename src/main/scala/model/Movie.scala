package model

class Movie(ID : Option[String],
           name : Option[String],
           Actors : Option[List[Actor]],
           description : Option[String],
           rate : Option[String])
    extends IMovieData
{

}
