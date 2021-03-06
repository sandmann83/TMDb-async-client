package org.edla.tmdb.api

import spray.json.DefaultJsonProtocol

object Protocol extends DefaultJsonProtocol {

  case class AuthenticateResult(expires_at: String, request_token: String, success: Boolean)
  case class ProductionCountry(iso_3166_1: String, name: String)
  case class Release(iso_3166_1: String, certification: String, release_date: String)
  case class Genre(id: Long, name: String)
  case class ProductionCompanie(name: String, id: Long)
  case class SpokenLanguage(iso_639_1: String, name: String)
  case class Collection(poster_path: Option[String], id: Long, name: String, backdrop_path: Option[String])
  case class Movie(runtime: Option[Long], status: String, backdrop_path: Option[String], overview: Option[String], title: String, vote_count: Long,
                   tagline: Option[String], belongs_to_collection: Option[Collection], original_title: String, poster_path: Option[String],
                   production_countries: List[ProductionCountry], revenue: Long, homepage: Option[String], imdb_id: String, id: Long,
                   release_date: String, budget: Long, popularity: Double, genres: List[Genre],
                   production_companies: List[ProductionCompanie], adult: Boolean, spoken_languages: List[SpokenLanguage])
  case class Result(original_title: String, poster_path: Option[String], release_date: String, id: Long, adult: Boolean, title: String,
                    popularity: Double, vote_count: Long, vote_average: Long, backdrop_path: Option[String])
  case class Results(total_results: Long, results: List[Result], page: Long, total_pages: Long)
  case class Images(still_sizes: List[String], poster_sizes: List[String], base_url: String, profile_sizes: List[String],
                    secure_base_url: String, logo_sizes: List[String], backdrop_sizes: List[String])
  case class Configuration(images: Images, change_keys: List[String])
  case class Cast(cast_id: Long, character: String, credit_id: String, name: String, order: Long, profile_path: Option[String])
  case class Crew(credit_id: String, departement: Option[String], id: Long, job: String, name: String, profile_path: Option[String])
  case class Credits(id: Long, cast: List[Cast], crew: List[Crew])
  case class Releases(id: Long, countries: List[Release])

  case class Error(status_code: Long, status_message: String)

  val noCrew = Crew("", None, 0, "", "Unknown", None)
  val unReleased = Release("", "", "")

  implicit val authenticateResultFormat = jsonFormat3(AuthenticateResult)
  implicit val productionCountriesFormat = jsonFormat2(ProductionCountry)
  implicit val genreFormat = jsonFormat2(Genre)
  implicit val productionCompanieFormat = jsonFormat2(ProductionCompanie)
  implicit val spokenLanguageFormat = jsonFormat2(SpokenLanguage)
  implicit val collectionFormat = jsonFormat4(Collection)
  implicit val movieFormat = jsonFormat22(Movie)
  implicit val resultFormat = jsonFormat10(Result)
  implicit val resultsFormat = jsonFormat4(Results)
  implicit val imagesFormat = jsonFormat7(Images)
  implicit val configurationFormat = jsonFormat2(Configuration)
  implicit val castFormat = jsonFormat6(Cast)
  implicit val crewFormat = jsonFormat6(Crew)
  implicit val creditsFormat = jsonFormat3(Credits)
  implicit val release = jsonFormat3(Release)
  implicit val releases = jsonFormat2(Releases)
  implicit val error = jsonFormat2(Error)

}