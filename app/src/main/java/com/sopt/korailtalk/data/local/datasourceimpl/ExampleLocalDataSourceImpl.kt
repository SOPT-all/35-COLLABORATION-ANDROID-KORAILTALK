package com.sopt.korailtalk.data.local.datasourceimpl

import com.sopt.korailtalk.data.local.datasource.ExampleLocalDataSource
import javax.inject.Inject

class ExampleLocalDataSourceImpl @Inject constructor(

): ExampleLocalDataSource {
    override var localData: String
        get() = getData()
        set(value) { }

    override fun getData(): String {
        return "Local Data"
    }
}