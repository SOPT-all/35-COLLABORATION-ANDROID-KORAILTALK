package com.sopt.korailtalk.data.local.datasource

interface ExampleLocalDataSource {
    var localData: String
    fun getData(): String
}