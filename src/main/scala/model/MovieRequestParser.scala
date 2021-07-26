package model

import scalaj.http.HttpRequest
import io.circe._
import io.circe.parser._
object MovieRequestParser
{
    def getActors(res : HttpRequest)
    {
        val body : scala.Predef.String = res.asString.body
        println(s"TAMIR: HERE: body: $body. t.getActors(MovieRequestParser.scala:11)")
    
        val json : Either[ParsingFailure, Json] = parse(body)
    
    }
}
