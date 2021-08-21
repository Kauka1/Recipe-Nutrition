package com.example.recipe_nutrition.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

//repository for both remote and local data sources, scoped for life of activity
@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localDataSource
}