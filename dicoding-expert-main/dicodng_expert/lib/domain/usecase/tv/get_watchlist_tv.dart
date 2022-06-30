import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/domain/entities/tv/tv.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

import '../../../common/failure.dart';

class GetWatchlistTv {
  final TvRepository _repository;

  GetWatchlistTv(this._repository);

  Future<Either<Failure, List<Tv>>> execute() {
    return _repository.getWatchlistTv();
  }
}
