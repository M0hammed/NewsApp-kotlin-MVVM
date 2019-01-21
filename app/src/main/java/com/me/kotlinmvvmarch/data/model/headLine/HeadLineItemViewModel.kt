package com.me.kotlinmvvmarch.data.model.headLine

import androidx.databinding.ObservableField

data class HeadLineItemViewModel(var imageHeadLine: ObservableField<String>,
                                 var title: ObservableField<String>,
                                 var description: ObservableField<String>)