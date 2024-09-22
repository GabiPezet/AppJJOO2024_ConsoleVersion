package UserInterface

enum class TicketTypeMenu (private val option: String) {
    TICKET_ELITE("*** 1. Buy selected ticket on ELITE TICKET            ***"),
    TICKET_PRO("*** 2. Buy selected ticket on PRO TICKET PRO          ***"),
    TICKET_ULTIMATE("*** 3. Buy selected ticket on ULTIMATE EVENT          ***");

    override fun toString(): String {
        return option
    }
}