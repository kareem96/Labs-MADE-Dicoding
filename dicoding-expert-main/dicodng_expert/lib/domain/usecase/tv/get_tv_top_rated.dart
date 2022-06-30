import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

import '../../entities/tv/tv.dart';

class GetTvTopRated {
  final TvRepository repository;

  GetTvTopRated(this.repository);

  Future<Either<Failure, List<Tv>>> execute() {
    return repository.getTvTopRated();
  }
}
