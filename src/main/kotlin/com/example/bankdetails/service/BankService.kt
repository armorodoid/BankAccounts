package com.example.bankdetails.service

import com.example.bankdetails.pojo.Accounts
import com.example.bankdetails.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BankService {
    @Autowired
    internal lateinit var bankRepository: BankRepository

    fun getAccount(i: Int) : Accounts {
        return bankRepository.findById(i).orElse(null)
    }

    fun getAllAccount() : List<Accounts> {
        return bankRepository.findAll()
    }

    fun deleteAccount(i: Int) {
        return bankRepository.deleteById(i)
    }

    fun postAccount(accounts: Accounts) {
        bankRepository.save(accounts)
    }

    fun putAccount(i: Int, am: Int) {
        var accounts : Accounts = getAccount(i)
        accounts.amount+=am
        bankRepository.save(accounts)
    }
}