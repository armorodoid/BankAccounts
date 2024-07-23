package com.example.bankdetails.controller

import com.example.bankdetails.pojo.Accounts
import com.example.bankdetails.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class BankController {

    @Autowired
    internal lateinit var bankService: BankService

    @GetMapping("/getAll")
    fun getAllAccounts() : List<Accounts> {
        return bankService.getAllAccount()
    }

    @GetMapping("/get/{id}")
    fun getAccount(@PathVariable id: Int) : Accounts {
        return bankService.getAccount(id)
    }

    @PostMapping("/addAccount")
    fun addAccount(@RequestBody request: Map<String, Any>) {
        val name = request["name"] as? String ?: ""
        val id = request["id"] as? Int ?: -1
        val amount = request["amount"] as? Int ?: 0

        bankService.postAccount(Accounts(name,id,amount))
    }

    @PatchMapping("/update")
    fun updateAccount(@RequestBody request: Map<String, Any>) {
        val id = request["id"] as? Int ?: -1
        val amount = request["amount"] as? Int ?: 0
        bankService.putAccount(id,amount)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteAccount(@PathVariable id: Int) : String {
        bankService.deleteAccount(id)
        return "Deleted"
    }
}