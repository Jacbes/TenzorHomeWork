package dev.jacbes.recyclerview.employeeslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dev.jacbes.recyclerview.R
import dev.jacbes.recyclerview.databinding.FragmentEmployeesBinding

class EmployeesFragment : Fragment(R.layout.fragment_employees) {

    private val binding by viewBinding(FragmentEmployeesBinding::bind)

    private lateinit var viewModel: EmployeesViewModel
    private val employeesAdapter =
        EmployeesAdapter(this::deleteEmployee, this::changeFavorite)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmployeesViewModel::class.java)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = employeesAdapter
            itemAnimator = null
            addItemDecoration(DividerItemDecoration(context, GridLayoutManager.VERTICAL))
            addItemDecoration(DividerItemDecoration(context, GridLayoutManager.HORIZONTAL))
        }

        viewModel.employeesList.observe(viewLifecycleOwner) {
            employeesAdapter.submitList(it)
        }

        binding.addRandomButton.setOnClickListener {
            viewModel.addRandom()
        }
    }

    private fun deleteEmployee(employeeId: Long) {
        viewModel.deleteEmployee(employeeId)
    }

    private fun changeFavorite(employeeId: Long, isFavorite: Boolean) {
        viewModel.changeFavorite(employeeId, isFavorite)
    }
}