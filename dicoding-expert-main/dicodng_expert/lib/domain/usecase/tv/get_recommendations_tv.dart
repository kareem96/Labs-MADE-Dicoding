import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/tv/tv.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

class GetRecommendationsTv {
  final TvRepository repository;

  GetRecommendationsTv(this.repository);

  Future<Either<Failure, List<Tv>>> execute(id) {
    return repository.getRecommendationsTv(id);
  }
}
