//package model
//
//import io.circe._
//import io.circe.parser._
//import scalaj.http.HttpRequest
//
//
//object MovieRequestParser
//{
//    val RESULTS = "results"
//    val ID = "id"
//    val IMAGE = "image"
//    val HEIGHT = "height"
//    val URL = "url"
//    val NAME = "name"
//    val MOVIE_TITLE = "l"
//    val KNOWN_FOR = "knownFor"
//    val ACTOR_ID_PREFIX = """/name/"""
//    val MOVIE_ID_PREFIX = """/title/"""
//    val STARS = "s"
//    val TITLE_TYPE = "q"  // TV series/TV movie...
//
//
////    implicit val moviesListDecoder = new Decoder[Movie]
////    {
////        override def apply(c : HCursor) : Decoder.Result[Movie] =
////            for
////            {
////                movies <- c.downField("d").as[String]
////
////
//////                    properties <- c.downField("properties").as[Map[String, String]]
//////                    geometryType <- c.downField("geometry").downField("type").as[String]
//////                    coords = c.downField("geometry").downField("coordinates")
////            } yield Movie(Some(movies))
////    }
//
//    implicit val movieDecorator = new Decoder[Movie]
//    {
//        override def apply(c : HCursor) : Decoder.Result[Movie] =
//            for
//            {
//                id <- c.downField("is").as[String]
////                    properties <- c.downField("properties").as[Map[String, String]]
////                    geometryType <- c.downField("geometry").downField("type").as[String]
////                    coords = c.downField("geometry").downField("coordinates")
//            } yield Movie(Some(id))
//    }
//
//
//
//    def getActors(res : HttpRequest)
//    {
//        val body : scala.Predef.String = res.asString.body
//        println(s"TAMIR: HERE: body: $body. t.getActors(MovieRequestParserLongResponse.scala:56)")
//
//        val json : Either[ParsingFailure, Json] = parse(body)
//        println(json.map(moviesListDecoder.decodeJson).right)
//    }
//
//
//
//}
//
//
////    def getActors(res : HttpRequest)
////    {
////        val body : scala.Predef.String = res.asString.body
////        println(s"TAMIR: HERE: body: $body. t.getActors(MovieRequestParserLongResponse.scala:11)")
////
////        val json : Either[ParsingFailure, Json] = parse(body)
////
////
////        val featureDecoder = new Decoder[Actor]
////        {
////            override def apply(c : HCursor) : Decoder.Result[Actor] =
////                for
////                {
////                    id <- c.downField("d").as[String]
//////                    properties <- c.downField("properties").as[Map[String, String]]
//////                    geometryType <- c.downField("geometry").downField("type").as[String]
//////                    coords = c.downField("geometry").downField("coordinates")
////                } yield new Actor(Some(id))
////        }
////
////        println(json.map(featureDecoder.decodeJson).right)
////    }