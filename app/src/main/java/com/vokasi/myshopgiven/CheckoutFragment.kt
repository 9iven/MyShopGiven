package com.vokasi.myshopgiven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController // Tambahkan import ini
import androidx.navigation.fragment.navArgs
import com.vokasi.myshopgiven.databinding.FragmentCheckoutBinding

class CheckoutFragment : Fragment() {
    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: CheckoutFragmentArgs by navArgs()
        binding.txtProductName.text = args.productName

        // edtAddress dipanggil langsung lewat binding di sini
        binding.edtAddress.setOnClickListener {
            val action = CheckoutFragmentDirections.actionCheckoutFragmentToAddressFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Biar nggak bikin memory leak
    }
}