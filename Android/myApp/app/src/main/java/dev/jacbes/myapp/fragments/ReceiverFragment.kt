package dev.jacbes.myapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dev.jacbes.myapp.R
import org.w3c.dom.Text

class ReceiverFragment : Fragment() {

    private lateinit var messageView: TextView
    private lateinit var readButtonView: Button

    private val model: SharedViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        Log.i("LifecycleTag", "ReceiverFragment: onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "ReceiverFragment: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LifecycleTag", "ReceiverFragment: onCreateView")
        return inflater.inflate(R.layout.receiver_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "ReceiverFragment: onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        messageView = view.findViewById(R.id.receiver_fragment_textview)

        model.message.observe(viewLifecycleOwner) { message ->
            messageView.text = message
        }

        readButtonView = view.findViewById(R.id.receiver_fragment_button)

        readButtonView.setOnClickListener {
            model.changeMessage("All messages is read")
        }
    }

    override fun onStart() {
        Log.i("LifecycleTag", "ReceiverFragment: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleTag", "ReceiverFragment: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleTag", "ReceiverFragment: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleTag", "ReceiverFragment: onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i("LifecycleTag", "ReceiverFragment: onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("LifecycleTag", "ReceiverFragment: onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("LifecycleTag", "ReceiverFragment: onDetach")
        super.onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("LifecycleTag", "ReceiverFragment: onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

}