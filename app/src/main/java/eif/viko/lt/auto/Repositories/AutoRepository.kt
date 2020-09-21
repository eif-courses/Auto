package eif.viko.lt.auto.Repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eif.viko.lt.auto.Models.Auto

object AutoRepository {
    private val db = mutableListOf<Auto>()
    var updatedList = MutableLiveData<List<Auto>>()


    fun getAutos():LiveData<List<Auto>>{
        db.clear()
        load()
        updatedList.value = db
        return updatedList
    }


    // Webserviso ar kitu vietu duomenys
    fun load(){
        db.add(Auto("BMW", "2.5 TDI", "https://loremflickr.com/320/240"))
        db.add(Auto("AUDI", "2.4 TDI", "https://loremflickr.com/320/240/dog"))
        db.add(Auto("OPEL", "2.2 TDI", "https://loremflickr.com/320/240"))
        db.add(Auto("NISSAN", "2.1 TDI", "https://loremflickr.com/320/240"))
        db.add(Auto("PORCHE", "1.5 TDI", "https://loremflickr.com/320/240"))
    }


}