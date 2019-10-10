package com.shohiebsense.bottomsheetdialogsample

import androidx.fragment.app.FragmentManager

class BaseDialog(
    var listener : DialogButtonClickedListener,
    var supportFragmentManager: FragmentManager) {

    companion object {
        const val STATE_POSITIVE_CLICKED = 0
        const val STATE_NEGATIVE_CLICKED = 1

        const val DIALOG_TYPE_SIMPLE = -1
        const val DIALOG_TYPE_PERSISTENT = -2
        const val DIALOG_TYPE_PERSISTENT_LOADING = -3
        const val DIALOG_TYPE_YES_NO = -4
        const val DIALOG_MESSAGE_ONLY = -5

    }
    var defaultTitle = "Notification"
    var defaultPositiveText = ""
    var defaultNegativeText = ""
    var message = ""

    lateinit var dialogFragment : BaseBottomSheetDialogFragment

    var isAutoDismiss = false
    var isCancelable = true
    var isPersistance = true





    fun showNoListener(){
        dialogFragment = BaseBottomSheetDialogFragment(DIALOG_TYPE_SIMPLE)
        showDialog()
    }

    fun showNoListenerMessageOnly(){
        dialogFragment = BaseBottomSheetDialogFragment(DIALOG_MESSAGE_ONLY)
        showDialog()
    }

    fun showPersistentLoading(){
        dialogFragment = BaseBottomSheetDialogFragment(DIALOG_TYPE_PERSISTENT_LOADING)
        showDialog()
    }

    fun showPersistent(){
        dialogFragment = BaseBottomSheetDialogFragment(DIALOG_TYPE_PERSISTENT)
        dialogFragment.listener = listener
        showDialog()
    }

    fun showYesNo(){
        dialogFragment = BaseBottomSheetDialogFragment(DIALOG_TYPE_YES_NO)
        dialogFragment.listener = listener
        showDialog()
    }

    private fun showDialog(){
        dialogFragment.show(supportFragmentManager, dialogFragment.tag)
    }
}