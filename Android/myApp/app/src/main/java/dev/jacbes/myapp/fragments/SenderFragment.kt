package dev.jacbes.myapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import dev.jacbes.myapp.R

class SenderFragment : Fragment() {

    private val model: SharedViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        Log.i("LifecycleTag", "SenderFragment: onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "SenderFragment: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LifecycleTag", "SenderFragment: onCreateView")
        return inflater.inflate(R.layout.sender_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "SenderFragment: onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.sender_fragment_button).setOnClickListener {
            model.changeMessage("Hello")
            replaceFragment()
        }

        view.findViewById<Button>(R.id.sender_fragment_add_button).setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.main_activity, ReceiverFragment())
                .commit()
        }

        view.findViewById<Button>(R.id.sender_fragment_replace_button).setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity, ReceiverFragment())
                .commit()
        }

        view.findViewById<Button>(R.id.sender_fragment_add_backstack_button).setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.main_activity, ReceiverFragment())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.sender_fragment_replace_backstack_button).setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity, ReceiverFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun replaceFragment() {
        Log.i("LifecycleTag", "SenderFragment: clickButton")
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity, ReceiverFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onStart() {
        Log.i("LifecycleTag", "SenderFragment: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleTag", "SenderFragment: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleTag", "SenderFragment: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleTag", "SenderFragment: onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i("LifecycleTag", "SenderFragment: onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("LifecycleTag", "SenderFragment: onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("LifecycleTag", "SenderFragment: onDetach")
        super.onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("LifecycleTag", "ReceiverFragment: onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

}