package com.guerber.taskapp.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.guerber.taskapp.R
import com.guerber.taskapp.databinding.BottomSheetBinding

fun Fragment.initToolbar(toolbar: Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    toolbar.setNavigationOnClickListener{ activity?.onBackPressed() }
}

fun Fragment.showBottomSheet(
    titleDialog:Int? = null,
    titleButton:Int? = null,
    message:String,
    onClick: () -> Unit = {}

){
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding = BottomSheetBinding.inflate(layoutInflater,null,false)

    binding.txtTitle.text = getText(titleDialog ?:R.string.text_title_warning)
    binding.txtMessage.text = message
    binding.btnConfirm.text = getText(titleButton?:R.string.text_button_warning)
    binding.btnConfirm.setOnClickListener{
        onClick()
        bottomSheetDialog.dismiss()
    }
    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}