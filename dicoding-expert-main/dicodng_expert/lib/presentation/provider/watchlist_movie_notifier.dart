import 'package:dicodng_expert/common/state_enum.dart';
import 'package:dicodng_expert/domain/entities/movie.dart';
import 'package:dicodng_expert/domain/usecase/get_watchlist_movies.dart';
import 'package:flutter/material.dart';

class WatchlistMovieNotifier extends ChangeNotifier {
  var _watchlistMovies = <Movie>[];

  List<Movie> get watchlistMovie => _watchlistMovies;

  var _watchlistState = RequestState.Empty;

  RequestState get watchlistState => _watchlistState;

  String _message = '';

  String get message => _message;

  WatchlistMovieNotifier({required this.getWatchlistMovies});

  final GetWatchlistMovies getWatchlistMovies;

  Future<void> fetchWatchlistMovies() async {
    _watchlistState = RequestState.Loading;
    notifyListeners();

    final result = await getWatchlistMovies.execute();
    result.fold((failure) {
      _watchlistState = RequestState.Error;
      _message = failure.message;
      notifyListeners();
    }, (data) {
      _watchlistState = RequestState.Loaded;
      _watchlistMovies = data;
      notifyListeners();
    });
  }
}
