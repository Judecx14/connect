package dev.fenix.ui.component.icon.type

import dev.fenix.ui.R

sealed class FenixIcons(val resId: Int) {
    object ChevronLeft : FenixIcons(R.drawable.ic_chevron_left)
    object UserRounded : FenixIcons(R.drawable.ic_user_round)
    object Bell : FenixIcons(R.drawable.ic_bell)
    object Locate : FenixIcons(R.drawable.ic_locate)
    object Bolt : FenixIcons(R.drawable.ic_bolt)
    object House : FenixIcons(R.drawable.ic_house)
    object ListRestart : FenixIcons(R.drawable.ic_list_restart)
    object Logout : FenixIcons(R.drawable.ic_log_out)
    object Zap : FenixIcons(R.drawable.ic_zap)
    object Store : FenixIcons(R.drawable.ic_store)
    object StickyNotePlus : FenixIcons(R.drawable.ic_sticky_note_plus)
}