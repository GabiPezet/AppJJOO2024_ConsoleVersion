package UserInterface

enum class ShopMenu (private val option: String) {
    PURCHASE("*** 1. BUY SELECTED TICKET                                 ***"),
    CANCEL_PURCHASE("*** 2. CANCEL TICKET PURCHASE                              ***");

    override fun toString(): String {
        return option
    }
}