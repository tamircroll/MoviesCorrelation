//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//import java.io.IOException;
//
//public  class Temp
//{
//    public static void fun()
//    {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr")
//                .get()
//                .addHeader("x-rapidapi-key", "4f9d05fe73mshe1dd9c5a146935cp12b329jsn532423ef2a63")
//                .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
//                .build();
//
//        Response response;
//        {
//            try
//            {
//                response = client.newCall(request).execute();
//                System.out.println("Tamir: HERE: " + response.message());
//            }
//            catch (IOException e)
//            {
//                System.out.println("Failed ! ! !");
//            }
//        }
//    }
//}