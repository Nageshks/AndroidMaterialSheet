package com.nageshempire.materialsheetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.nageshempire.materialsheetexample.databinding.ActivityMainBinding
import com.nageshempire.materialsheetlib.ConfirmationSheet
import com.nageshempire.materialsheetlib.showDialog

class MainActivity : AppCompatActivity(), FragmentResultListener {

    companion object {
        const val REQUEST_KEY_BOTTOM_SHEET_DIALOG = "282525"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // show bottom sheet dialog example
        binding.btnSheetDialog.setOnClickListener {
            showBottomSheetDialogExample()
        }

        // add result listener once
        supportFragmentManager.setFragmentResultListener(REQUEST_KEY_BOTTOM_SHEET_DIALOG, this, this)
    }

    // receive result
    override fun onFragmentResult(requestKey: String, result: Bundle) {
        when (requestKey) {
            REQUEST_KEY_BOTTOM_SHEET_DIALOG -> handleShowBottomSheetDialogExample(result)
        }
    }

    private fun showBottomSheetDialogExample() {
        val dialog = ConfirmationSheet.create(
            REQUEST_KEY_BOTTOM_SHEET_DIALOG, // request key
            getString(R.string.confirmation_history_clearance) // Title
        )
        showDialog(dialog)
    }

    private fun handleShowBottomSheetDialogExample(result: Bundle) {
        val confirmed = ConfirmationSheet.isConfirmed(result)
        val message = if (confirmed) getString(R.string.success_clear_history) else getString(R.string.cancelled)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}