import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/tv/tv.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

class SearchTv {
  final TvRepository repository;

  SearchTv(this.repository);

  Future<Either<Failure, List<Tv>>> execute(String query) {
    return repository.searchTv(query);
  }
}
