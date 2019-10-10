package com.shohiebsense.bottomsheetdialogsample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet_dialog.*


class BaseBottomSheetDialogFragment(
    val type : Int) : BottomSheetDialogFragment() {
    var listener : DialogButtonClickedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when(type){
            BaseDialog.DIALOG_TYPE_SIMPLE   -> {
                isCancelable = false
                button_no.visibility = View.GONE
                button_yes.text = "Ok"
            }
            BaseDialog.DIALOG_TYPE_PERSISTENT -> {
                isCancelable = false
            }
            BaseDialog.DIALOG_TYPE_YES_NO -> {
                isCancelable = false
            }
            BaseDialog.DIALOG_TYPE_PERSISTENT_LOADING -> {
                isCancelable = false
                image_icon.visibility = View.INVISIBLE
                button_no.visibility = View.INVISIBLE
                button_yes.visibility = View.INVISIBLE
                progress_bar_loading.visibility = View.VISIBLE
            }
            BaseDialog.DIALOG_MESSAGE_ONLY -> {
                isCancelable = true
                button_yes.visibility = View.INVISIBLE
                button_no.visibility = View.INVISIBLE
            }
        }

        button_no.setOnClickListener {
            dismiss()
            listener?.onDialogDismissed(BaseDialog.STATE_NEGATIVE_CLICKED)
        }
        button_yes.setOnClickListener {
            dismiss()
            listener?.onDialogDismissed(BaseDialog.STATE_POSITIVE_CLICKED)
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
    }



}
