package com.example.fragmentest.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentest.InputEntries
import com.example.fragmentest.PlayView
import com.example.fragmentest.QPICalculator
import com.example.fragmentest.R
import com.example.fragmentest.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val inputEntriesButton: Button = root.findViewById(R.id.redirectInputEntries)
        inputEntriesButton.setOnClickListener {
            val toInputEntries: Intent = Intent(this.context, InputEntries::class.java)
            startActivity(toInputEntries)
        }

        val qpiCalculatorButton: Button = root.findViewById(R.id.redirectQPI)
        qpiCalculatorButton.setOnClickListener {
            val toQPICalculator: Intent = Intent(this.context, QPICalculator::class.java)
            startActivity(toQPICalculator)
        }

        val playViewButton: Button = root.findViewById(R.id.redirectPlay)
        playViewButton.setOnClickListener {
            val toPlayView: Intent = Intent(this.context, PlayView::class.java)
            startActivity(toPlayView)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}