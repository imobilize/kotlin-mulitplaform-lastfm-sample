package uk.co.imobilize.lastfmsampleapp.android

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun Fragment.show(fragmentManager: FragmentManager, addToBackstack: Boolean) {

    val myFragment = fragmentManager.fragments.lastOrNull()//return current visible fragment or null

    if (myFragment != null && this::class == myFragment::class) {
        return
    }

    val transaction = fragmentManager.beginTransaction()

    transaction.replace(
        R.id.fragmentContainer,
        this,
        this.javaClass.name
    )
    if (addToBackstack) {
        transaction.addToBackStack(this.javaClass.name)
    }
    transaction.commit()
}

fun Fragment.showError(title: String = "There was an error", message: String) {

    AlertDialog.Builder(this.context)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        .show()
}
