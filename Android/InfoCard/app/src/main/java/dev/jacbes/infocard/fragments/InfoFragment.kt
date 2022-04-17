package dev.jacbes.infocard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dev.jacbes.infocard.R
import dev.jacbes.infocard.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private var fragmentInfoBinding: FragmentInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentInfoBinding.bind(view)
        fragmentInfoBinding = binding

        setImagePhoto(binding)
        setTexts(binding)
        setImageAchievements(binding)
        setMessageListener(binding)
    }

    private fun setImagePhoto(binding: FragmentInfoBinding) {
        val imageUrl = "https://avatars.githubusercontent.com/u/47550283?v=4"

        Glide.with(this)
            .load(imageUrl)
            .override(1920, 1080)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imagePhoto)
    }

    private fun setTexts(binding: FragmentInfoBinding) {
        binding.textFio.text = "Besedin Yakov Eduardovich"
        binding.textPostInCompany.text = "Computer scientist"
        binding.textDepartment.text = "Google, Amazon, Facebook, Apple, Microsoft"

        binding.textEmail.text = "Email: email@email.com"
        binding.textPhone.text = "Phone: 88005555555"
    }

    private fun setImageAchievements(binding: FragmentInfoBinding) {
        val imageUrl =
            "https://cdn.icon-icons.com/icons2/2175/PNG/512/education_school_ribbon_award_achievement_recognition_best_icon_133341.png"
        for (i in 1..6) {
            val imageView = ImageView(requireContext())

            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

            binding.fragmentHorizontalLayout.addView(imageView)
        }
    }

    private fun setMessageListener(binding: FragmentInfoBinding) {
        val clickMessage = Snackbar.make(
            binding.infoFragment,
            "Message to me",
            Snackbar.LENGTH_LONG
        )
        binding.messageButton.setOnClickListener {
            clickMessage.show()
        }
    }

    override fun onDestroyView() {
        fragmentInfoBinding = null
        super.onDestroyView()
    }
}