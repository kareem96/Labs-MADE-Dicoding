import 'package:dartz/dartz.dart';
import 'package:dicodng_expert/common/failure.dart';
import 'package:dicodng_expert/domain/entities/tv/tv_detail.dart';
import 'package:dicodng_expert/domain/repositories/tv_repository.dart';

class GetTvDetail {
  final TvRepository repository;

  GetTvDetail(this.repository);

  Future<Either<Failure, TvDetail>> execute(int id) {
    return repository.getDetailTv(id);
  }
}
