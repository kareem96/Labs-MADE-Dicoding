
import 'package:data_connection_checker/data_connection_checker.dart';
import 'package:dicodng_expert/presentation/provider/movie_detail_notifier.dart';
import 'package:dicodng_expert/presentation/provider/movie_list_notifier.dart';
import 'package:dicodng_expert/presentation/provider/tv/tv_list_notifier.dart';
import 'package:get_it/get_it.dart';
import 'package:http/http.dart' as http;

import 'domain/repositories/tv_repository.dart';
import 'domain/usecase/tv/get_recommendations_tv.dart';

final locator = GetIt.instance;

void init() {
  ///provider movies
  locator.registerFactory(() => MovieListNotifier(
        getNowPlayingMovies: locator(),
        getPopularMovies: locator(),
        getTopRatedMovies: locator(),
      ));

  ///provider tv
  locator.registerFactory(() => TvListNotifier(
        getTvAiringToday: locator(),
        getTvOnTheAir: locator(),
        getTvPopular: locator(),
        getTvTopRated: locator(),
      ));

  locator.registerFactory(() => TvDetailNotifier(
        getTvDetail: locator(),
        getWatchlistStatusTv: locator(),
        saveWatchlistTv: locator(),
        removeWatchlistTv: locator(),

        getTvRecommendations: locator(),
      ));

  locator.registerFactory(() => MovieDetailNotifier(
        getMovieDetail: locator(),
        getMovieRecommendations: locator(),
        getWatchListStatus: locator(),
        saveWatchlist: locator(),
        removeWatchlist: locator(),
      ));

  ///
  locator.registerFactory(() => MovieSearchNotifier(searchMovies: locator()));
  locator.registerFactory(() => TvSearchNotifier(searchTv: locator()));

  //
  locator.registerFactory(() => PopularMoviesNotifier(locator()));
  locator.registerFactory(
      () => TopRatedMoviesNotifier(getTopRatedMovies: locator()));

  ///
  locator.registerFactory(
      () => WatchlistMovieNotifier(getWatchlistMovies: locator()));
  locator.registerFactory(() => WatchlistTvNotifier(getWatchlistTv: locator()));

  ///
  locator.registerFactory(() => TvOnTheAirNotifier(getTvOnTheAir: locator()));
  locator.registerFactory(() => TvAiringTodayNotifier(getTvAiringToday: locator()));
  locator.registerFactory(() => TvPopularNotifier(locator()));

  ///use case movie
  locator.registerLazySingleton(() => GetNowPlayingMovies(locator()));
  locator.registerLazySingleton(() => GetPopularMovies(locator()));
  locator.registerLazySingleton(() => GetTopRatedMovies(locator()));
  locator.registerLazySingleton(() => GetMovieDetail(locator()));
  locator.registerLazySingleton(() => GetMovieRecommendations(locator()));

  ///
  locator.registerLazySingleton(() => SearchMovies(locator()));
  locator.registerLazySingleton(() => SearchTv(locator()));

  ///use case tv
  locator.registerLazySingleton(() => GetTvAiringToday(locator()));
  locator.registerLazySingleton(() => GetTvOnTheAir(locator()));
  locator.registerLazySingleton(() => GetTvDetail(locator()));
  locator.registerLazySingleton(() => GetTvPopular(locator()));
  locator.registerLazySingleton(() => GetTvTopRated(locator()));
  locator.registerLazySingleton(() => GetRecommendationsTv(locator()));


  ///watchlist movie
  locator.registerLazySingleton(() => GetWatchListStatus(locator()));
  locator.registerLazySingleton(() => SaveWatchlist(locator()));
  locator.registerLazySingleton(() => RemoveWatchlist(locator()));
  locator.registerLazySingleton(() => GetWatchlistMovies(locator()));

  ///watchlist tv
  locator.registerLazySingleton(() => GetWatchlistStatusTv(locator()));
  locator.registerLazySingleton(() => SaveWatchlistTv(locator()));
  locator.registerLazySingleton(() => RemoveWatchlistTv(locator()));
  locator.registerLazySingleton(() => GetWatchlistTv(locator()));

  ///repository movie
  locator.registerLazySingleton<MovieRepository>(() => MovieRepositoryImpl(
        remoteDataSource: locator(),
        localDataSource: locator(),
        networkInfo: locator(),
      ));

  ///repository tv
  locator.registerLazySingleton<TvRepository>(() => TvRepositoryImpl(
        remoteDataSource: locator(),
        tvLocalDataSource: locator(),
        networkInfo: locator(),
      ));

  ///data source
  locator.registerLazySingleton<MovieRemoteDataSource>(
      () => MovieRemoteDataSourceImpl(client: locator()));
  locator.registerLazySingleton<MovieLocalDataSource>(
      () => MovieLocalDataSourceImpl(databaseHelper: locator()));
  locator.registerLazySingleton<TvLocalDataSource>(
      () => TvLocalDataSourceImpl(databaseHelperTv: locator()));

  ///helper
  locator.registerLazySingleton<DatabaseHelper>(() => DatabaseHelper());
  locator.registerLazySingleton<DatabaseHelperTv>(() => DatabaseHelperTv());

  ///network
  locator.registerLazySingleton<NetworkInfo>(() => NetworkInfoImpl(locator()));

  ///external
  locator.registerLazySingleton(() => http.Client());
  locator.registerLazySingleton(() => DataConnectionChecker());
}
