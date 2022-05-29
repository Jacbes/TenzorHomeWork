package dev.jacbes.recyclerview.employeeslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.jacbes.recyclerview.databinding.EmployeesListItemBinding
import dev.jacbes.recyclerview.employeeslist.model.Employee

class EmployeesAdapter(
    private val deleteAction: (Long) -> Unit,
    private val favoriteAction: (Long, Boolean) -> Unit
) : ListAdapter<Employee, EmployeesViewHolder>(EmployeeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        val binding = EmployeesListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EmployeesViewHolder(binding, deleteAction, favoriteAction)
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: EmployeesViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (payloads[0] == true) {
                holder.bindFavoriteState(getItem(position).isFavorite)
            }
        }
    }
}

class EmployeesViewHolder(
    private val binding: EmployeesListItemBinding,
    private val deleteAction: (Long) -> Unit,
    private val favoriteAction: (Long, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var employee: Employee

    init {
        binding.deleteButton.setOnClickListener {
            deleteAction(employee.id)
        }

        binding.favoriteButton.setOnClickListener {
            favoriteAction(employee.id, !it.isSelected)
        }
    }

    fun bind(employee: Employee) {
        this.employee = employee

        binding.fullname.text = employee.fullName
        binding.department.text = employee.department
        binding.favoriteButton.isSelected = employee.isFavorite

        Glide.with(binding.photo.context)
            .load(employee.photoUrl)
            .centerCrop()
            .into(binding.photo)
    }

    fun bindFavoriteState(isFavorite: Boolean) {
        binding.favoriteButton.isSelected = isFavorite
    }
}

object EmployeeDiffCallback : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Employee, newItem: Employee): Any? {
        return if (oldItem.isFavorite != newItem.isFavorite) true else null
    }
}