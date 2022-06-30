import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/tv/tv.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

class GetTvAiringToday {
  final TvRepository repository;

  GetTvAiringToday(this.repository);

  Future<Either<Failure, List<Tv>>> execute() {
    return repository.getTvAiringToday();
  }
}
