import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/tv/tv_detail.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

class SaveWatchlistTv {
  final TvRepository repository;

  SaveWatchlistTv(this.repository);

  Future<Either<Failure, String>> execute(TvDetail tvDetail) {
    return repository.saveWatchlistTv(tvDetail);
  }
}
