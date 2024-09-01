package UserInterface

enum class UserMenu(private val option: String) {
    VIEW_ACCOUNT_MONEY("*** 1. See balance available for purchases            ***"),
    VIEW_SELECT_SPORTING_EVENT("*** 2. View and select available Sporting Event       ***"),
    VIEW_SHOPPING_CART("*** 3. See selected event in your shopping cart       ***"),
    VIEW_HISTORY("*** 4. View purchase history                          ***"),
    MAKE_A_PURCHASE("*** 5. Make purchase of the selected Sporting Event   ***"),
    VIEW_OLYMPIC_MEDAL_TABLE("*** 6. See the Olympic medal table                    ***"),
    LOG_OUT_USER("*** 7. Log out                                        ***");

    override fun toString(): String {
        return option
    }
}