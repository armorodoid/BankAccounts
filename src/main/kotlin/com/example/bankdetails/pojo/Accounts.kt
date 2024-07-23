package com.example.bankdetails.pojo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "bankAccount")
data class Accounts(
    var name: String,
    @Id var id: Int,
    var amount: Int
)