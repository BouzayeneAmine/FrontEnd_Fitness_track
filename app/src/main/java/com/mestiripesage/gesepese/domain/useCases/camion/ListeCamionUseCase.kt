package com.mestiripesage.gesepese.domain.useCases.camion

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.CamionRepositoryImp
import com.mestiripesage.gesepese.domain.repository.ICamionRepository
import io.reactivex.Observable

class ListeCamionUseCase{
private  val camionRepository : ICamionRepository = CamionRepositoryImp()
sealed class Result {
    object  Loading : Result()
    data class Success(val userResponse: Data<List<Camion>>) :
        Result()
    data class Failure (val throwable: Throwable) : Result()

}
fun execute(): Observable<Result> {
    return camionRepository.camiontGetAll()
        .doOnNext{
            Result.Success(
                it
            )
        }
        .map { Result.Success(
            it
        ) as Result
        }
        .onErrorReturn{
            Result.Failure(
                it
            )
        }
        .startWith(Result.Loading)


}
}
