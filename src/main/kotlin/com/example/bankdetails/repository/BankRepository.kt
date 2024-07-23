package com.example.bankdetails.repository

import com.example.bankdetails.pojo.Accounts
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BankRepository: MongoRepository<Accounts, Int>