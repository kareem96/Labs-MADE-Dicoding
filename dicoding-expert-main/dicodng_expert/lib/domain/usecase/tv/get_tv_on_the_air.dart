import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

import '../../entities/tv/tv.dart';

class GetTvOnTheAir {
  final TvRepository repository;

  GetTvOnTheAir(this.repository);

  Future<Either<Failure, List<Tv>>> execute() {
    return repository.getTvOnTheAir();
  }
}
