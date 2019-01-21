package com.me.kotlinmvvmarch.data.model.news

import androidx.databinding.ObservableField

data class NewsItemViewModel(var id: ObservableField<String>,
                             var name: ObservableField<String>,
                             val description: ObservableField<String>)