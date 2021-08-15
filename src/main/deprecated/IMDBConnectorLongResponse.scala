//package controller
//
//import model.MovieRequestParser
//import scalaj.http.{Http, HttpRequest}
//
//object IMDBConnector
//{
//    val URL = """https://imdb8.p.rapidapi.com"""
//    val KEY = "4f9d05fe73mshe1dd9c5a146935cp12b329jsn532423ef2a63"
//    val RAPIDAPI_HOST = "imdb8.p.rapidapi.com"
//    val X_RAPIDAPI_KEY = "x-rapidapi-key"
//    val X_RAPIDAPI_HOST = "x-rapidapi-host"
//
//    // ---------------- Public -------------------------
//
//    def getActors(actor : String) /*: List[Actor]*/ =
//    {
//        val titles = getTitleAutoComplete(actor)
//    }
//
//
//    // ---------------- Private -------------------------
//
//    private def getTitleAutoComplete(titlePrefix : String)
//    {
//        val result : HttpRequest =
//            createRequest("auto-complete")
//                .param("""q""", """game of thr""")
//
//        val res = MovieRequestParser.getActors(result)
//
////        println("Result: " + result.asString)
//    }
//
//
//    private def createRequest(path : String) : HttpRequest =
//    {
//        val result : HttpRequest = Http(s"$URL/$path")
//            .header(X_RAPIDAPI_KEY, KEY)
//            .header(X_RAPIDAPI_HOST, RAPIDAPI_HOST)
//        result
//    }
//}
