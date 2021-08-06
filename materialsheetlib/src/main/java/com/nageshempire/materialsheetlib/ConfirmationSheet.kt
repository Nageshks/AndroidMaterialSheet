package com.nageshempire.materialsheetlib
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nageshempire.materialsheetlib.N.ARGUMENT_REQUEST_KEY
import com.nageshempire.materialsheetlib.N.SELF_EXTRA


class ConfirmationSheet : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.sheet_confirmation, container, false) as TextView
        view.apply {
            text = requireArguments().getString(ARGUMENT_TITLE)
            setOnClickListener {
                sendConfirmation(true)
                dismiss()
            }
        }
        return view
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        sendConfirmation(false)
    }

    private fun sendConfirmation(boolean: Boolean) {
        setFragmentResult(
            checkNotNull(arguments?.getString(ARGUMENT_REQUEST_KEY)),
            bundleOf(
                RESULT_CONFIRMED to boolean,
                SELF_EXTRA to arguments?.getBundle(SELF_EXTRA)
            )
        )
    }

    companion object {

        private const val ARGUMENT_TITLE = "request_key_title"
        private const val RESULT_CONFIRMED = "request_key_confirmation_result"

        fun create(requestKey: String, title: String, extras: Bundle? = null): ConfirmationSheet = ConfirmationSheet().also {
            it.arguments = bundleOf(
                ARGUMENT_REQUEST_KEY to requestKey,
                ARGUMENT_TITLE to title,
                SELF_EXTRA to extras
            )
        }

        fun isConfirmed(data : Bundle) = data.getBoolean(RESULT_CONFIRMED,false)
        fun getExtra(data : Bundle) = data.getBundle(SELF_EXTRA)
    }

}