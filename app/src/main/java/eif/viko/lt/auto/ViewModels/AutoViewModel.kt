package eif.viko.lt.auto.ViewModels

import androidx.lifecycle.ViewModel
import eif.viko.lt.auto.Repositories.AutoRepository

class AutoViewModel:ViewModel(){

    val autoRepository = AutoRepository
    fun getAutos() = autoRepository.getAutos()
}