import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/movie_detail.dart';
import 'package:dicodng_expert/domain/repositories/movie_respository.dart';

class RemoveWatchlist {
  final MovieRepository repository;

  RemoveWatchlist(this.repository);

  Future<Either<Failure, String>> execute(MovieDetail movie) {
    return repository.removeWatchlist(movie);
  }
}
