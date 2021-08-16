package model

import io.circe.Encoder
import io.circe.generic.semiauto.deriveEncoder

object DataHandler
{
    implicit val genderEncoder : Encoder[SearchType.Value] = Encoder.encodeEnumeration(SearchType)
    implicit val keyValueItemTypeEncoder : Encoder[KeyValueItem] = deriveEncoder[KeyValueItem]
    implicit val posterDataItemTypeEncoder : Encoder[PosterDataItem] = deriveEncoder[PosterDataItem]
    implicit val ratingDataTypeEncoder : Encoder[RatingData] = deriveEncoder[RatingData]
    implicit val tvEpisodeInfoTypeEncoder : Encoder[TvEpisodeInfo] = deriveEncoder[TvEpisodeInfo]
    implicit val similarShortTypeEncoder : Encoder[SimilarShort] = deriveEncoder[SimilarShort]
    implicit val starShortTypeEncoder : Encoder[StarShort] = deriveEncoder[StarShort]
    implicit val boxOfficeShortTypeEncoder : Encoder[BoxOfficeShort] = deriveEncoder[BoxOfficeShort]
    implicit val companyShortTypeEncoder : Encoder[CompanyShort] = deriveEncoder[CompanyShort]
    implicit val searchResultTypeEncoder : Encoder[SearchResult] = deriveEncoder[SearchResult]
    implicit val imageDataDetailTypeEncoder : Encoder[ImageDataDetail] = deriveEncoder[ImageDataDetail]
    implicit val castMovieTypeEncoder : Encoder[CastMovie] = deriveEncoder[CastMovie]
    implicit val knownForTypeEncoder : Encoder[KnownFor] = deriveEncoder[KnownFor]
    implicit val wikipediaDataPlotTypeEncoder : Encoder[WikipediaDataPlot] = deriveEncoder[WikipediaDataPlot]
    implicit val castShortItemTypeEncoder : Encoder[CastShortItem] = deriveEncoder[CastShortItem]
    implicit val actorShortTypeEncoder : Encoder[ActorShort] = deriveEncoder[ActorShort]
    implicit val trailerDataTypeEncoder : Encoder[TrailerData] = deriveEncoder[TrailerData]
    implicit val tvSeriesInfoTypeEncoder : Encoder[TvSeriesInfo] = deriveEncoder[TvSeriesInfo]
    implicit val wikipediaDataTypeEncoder : Encoder[WikipediaData] = deriveEncoder[WikipediaData]
    implicit val nameDataTypeEncoder : Encoder[NameData] = deriveEncoder[NameData]
    implicit val castShortTypeEncoder : Encoder[CastShort] = deriveEncoder[CastShort]
    implicit val imageDataTypeEncoder : Encoder[ImageData] = deriveEncoder[ImageData]
    implicit val posterDataTypeEncoder : Encoder[PosterData] = deriveEncoder[PosterData]
    implicit val searchDataTypeEncoder : Encoder[SearchData] = deriveEncoder[SearchData]
    implicit val fullCastDataTypeEncoder : Encoder[FullCastData] = deriveEncoder[FullCastData]
    implicit val titleDataTypeEncoder : Encoder[TitleData] = deriveEncoder[TitleData]
}


// --------- Complex Data ---------------

case class TitleData(
    id : String,
    title : Option[String],
    originalTitle : Option[String],
    fullTitle : Option[String],
    year : Option[String],
    releaseDate : Option[String],
    runtimeMins : Option[String],
    runtimeStr : Option[String],
    plot : Option[String],
    plotLocal : Option[String],
    plotLocalIsRtl : Option[Boolean],
    awards : Option[String],
    image : Option[String],
    `type` : Option[String],
    directors : Option[String],
    directorList : Option[List[StarShort]],
    writers : Option[String],
    writerList : Option[List[StarShort]],
    stars : Option[String],
    starList : Option[List[StarShort]],
    actorList : Option[List[ActorShort]],
    fullCast : Option[FullCastData],
    genres : Option[String],
    genreList : Option[List[KeyValueItem]],
    companies : Option[String],
    companyList : Option[List[CompanyShort]],
    countries : Option[String],
    countryList : Option[List[KeyValueItem]],
    languages : Option[String],
    languageList : Option[List[KeyValueItem]],
    contentRating : Option[String],
    iMDbRating : Option[String],
    iMDbRatingVotes : Option[String],
    metacriticRating : Option[String],
    ratings : Option[RatingData],
    wikipedia : Option[WikipediaData],
    posters : Option[PosterData],
    images : Option[ImageData],
    trailer : Option[TrailerData],
    boxOffice : Option[BoxOfficeShort],
    tagline : Option[String],
    keywords : Option[String],
    keywordList : Option[List[String]],
    similars : Option[List[SimilarShort]],
    tvSeriesInfo : Option[TvSeriesInfo],
    tvEpisodeInfo : Option[TvEpisodeInfo],
    errorMessage : Option[String])

case class SearchData(
    searchType : Option[String],
    expression : Option[String],
    results : Option[List[SearchResult]],
    errorMessage : Option[String])

case class PosterData(
    imDbId : String,
    title : Option[String],
    fullTitle : Option[String],
    `type` : Option[String],
    year : Option[String],
    posters : Option[List[PosterDataItem]],
    backdors : Option[List[PosterDataItem]],
    errorMessage : Option[String])

case class ImageData(
    imDbId : String,
    title : Option[String],
    fullTitle : Option[String],
    `type` : Option[String],
    year : Option[String],
    items : Option[List[ImageDataDetail]],
    errorMessage : Option[String])

case class FullCastData(
    imDbId : String,
    title : Option[String],
    fullTitle : Option[String],
    `type` : Option[String],
    year : Option[String],
    directors : Option[CastShort],
    writers : Option[CastShort],
    actors : Option[List[ActorShort]],
    others : Option[List[CastShort]],
    errorMessage : Option[String])

case class CastShort(
    job : Option[String],
    items : Option[List[CastShortItem]])

case class NameData(
    id : String,
    name : Option[String],
    role : Option[String],
    image : Option[String],
    summary : Option[String],
    birthDate : Option[String],
    deathDate : Option[String],
    awards : Option[String],
    height : Option[String],
    knownFors : Option[List[KnownFor]],
    castMovies : Option[List[CastMovie]],
    errorMessage : Option[String])

case class WikipediaData(
    imDbId : String,
    title : Option[String],
    fullTitle : Option[String],
    `type` : Option[String],
    year : Option[String],
    language : Option[String],
    titleInLanguage : Option[String],
    url : Option[String],
    plotShort : Option[WikipediaDataPlot],
    plotFull : Option[WikipediaDataPlot],
    errorMessage : Option[String])

case class TvSeriesInfo(
    yearEnd : Option[String],
    creators : Option[String],
    creatorList : Option[List[StarShort]],
    seasons : Option[List[String]])


// -------------- String only -------------------

case class TrailerData(
    imDbId : String,
    title : Option[String],
    fullTitle : Option[String],
    `type` : Option[String],
    year : Option[String],
    videoId : Option[String],
    videoTitle : Option[String],
    videoDescription : Option[String],
    thumbnailUrl : Option[String],
    uploadDate : Option[String],
    link : Option[String],
    linkEmbed : Option[String],
    errorMessage : Option[String])

case class RatingData(
    imDbId : String,
    title : Option[String],
    fullTitle : Option[String],
    `type` : Option[String],
    year : Option[String],
    iMDb : Option[String],
    metacritic : Option[String],
    theMovieDb : Option[String],
    rottenTomatoes : Option[String],
    tV_com : Option[String],
    filmAffinity : Option[String],
    errorMessage : Option[String]) // IMDb Plot always en, TMDb Plot translate

case class PosterDataItem(
    id : String,
    link : Option[String],
    aspectRatio : Option[Double],
    language : Option[String],
    width : Option[Int],
    height : Option[Int])


case class TvEpisodeInfo(
    seriesId : Option[String],
    seriesTitle : Option[String],
    seriesFullTitle : Option[String],
    seriesYear : Option[String],
    seriesYearEnd : Option[String],
    seasonNumber : Option[String],
    episodeNumber : Option[String],
    previousEpisodeId : Option[String],
    nextEpisodeId : Option[String])

case class SimilarShort(
    id : String,
    title : Option[String],
    image : Option[String])

case class StarShort(
    id : String,
    name : Option[String])

case class BoxOfficeShort(
    budget : Option[String],
    openingWeekendUSA : Option[String],
    grossUSA : Option[String],
    cumulativeWorldwideGross : Option[String])

case class CompanyShort(
    id : String,
    name : Option[String])

case class SearchResult(
    id : String,
    resultType : Option[String],
    image : Option[String],
    title : Option[String],
    description : Option[String])

case class ImageDataDetail(
    title : Option[String],
    image : Option[String])

case class CastMovie(
    id : String,
    role : Option[String],
    title : Option[String],
    originalTitle : Option[String],
    year : Option[String])  // id =  Movie Id

case class KnownFor(
    id : String,
    title : Option[String],
    fullTitle : Option[String],
    year : Option[String],
    role : Option[String],
    image : Option[String]) // id =  Movie Id

case class WikipediaDataPlot(
    PlainText : Option[String],
    Html : Option[String])

case class CastShortItem(
    id : String,
    name : Option[String],
    description : Option[String])

case class ActorShort(
    id : String,
    image : Option[String],
    name : Option[String],
    asCharacter : Option[String])

case class KeyValueItem(
    key : Option[String],
    value : Option[String])

object SearchType extends Enumeration
{
    type SearchType = Value
    val Title,
    Movie,
    Series,
    Name,
    Episode,
    Company,
    Keyword,
    All = Value
}