package dev.jacbes.recyclerview.employeeslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.jacbes.recyclerview.employeeslist.model.Employee
import java.util.concurrent.atomic.AtomicLong

class EmployeesViewModel : ViewModel() {
    private val _employeesList = MutableLiveData<List<Employee>>(emptyList())
    val employeesList: LiveData<List<Employee>> = _employeesList

    var lastId = AtomicLong(0)

    init {
        _employeesList.value = getMockEmployees()
    }

    fun addRandom() {
        _employeesList.value = _employeesList.value?.toMutableList()?.apply {
            add(getMockEmployees().random())
        }
    }

    fun deleteEmployee(employeeId: Long) {
        _employeesList.value = _employeesList.value?.filter {
            it.id != employeeId
        }
    }

    fun changeFavorite(employeeId: Long, isFavorite: Boolean) {
        _employeesList.value = _employeesList.value?.map {
            if (it.id == employeeId) {
                it.copy(isFavorite = isFavorite)
            } else {
                it
            }
        }
    }

    private fun getMockEmployees() = listOf(
        Employee(
            lastId.getAndIncrement(),
            "Rar Lad",
            "https://this-person-does-not-exist.com/img/avatar-08ce678530857bb55fbe84d3ae099607.jpg",
            "First department",
            false
        ),
        Employee(
            lastId.getAndIncrement(),
            "Tat Lad",
            "https://this-person-does-not-exist.com/img/avatar-b0d09326bdc78c9aa1fb68dbaa01d9e0.jpg",
            "Second department",
            false
        ),
        Employee(
            lastId.getAndIncrement(),
            "Yay Lad",
            "https://this-person-does-not-exist.com/img/avatar-1d34a3f1c2e5ec7500722f8a733a91c6.jpg",
            "Third department",
            false
        ),
        Employee(
            lastId.getAndIncrement(),
            "Uau Lad",
            "https://this-person-does-not-exist.com/img/avatar-51eba168e9ffc49b4be3bbd8788353fe.jpg",
            "Fourth department",
            false
        ),
        Employee(
            lastId.getAndIncrement(),
            "Iai Lad",
            "https://this-person-does-not-exist.com/img/avatar-a9b9e5c2e63a751ef82a5e03832eb363.jpg",
            "Fifth department",
            false
        )
    )
}