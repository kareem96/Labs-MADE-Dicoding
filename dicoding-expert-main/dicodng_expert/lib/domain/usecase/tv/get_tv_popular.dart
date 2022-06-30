import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/tv/tv.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

class GetTvPopular {
  final TvRepository repository;

  GetTvPopular(this.repository);

  Future<Either<Failure, List<Tv>>> execute() {
    return repository.getTvPopular();
  }
}
