package UserInterface

import data.Event
import data.User
import repositories.UserRepository
import kotlin.enums.EnumEntries

fun main () {
    val menuLogin = LoginMenu.entries
    var selectedLoginOption: Int
    var loginOption: LoginMenu

    do {
        showLoginMenu(menuLogin)
        selectedLoginOption = evaluateEnteredOption(2)
        loginOption = LoginMenu.entries[selectedLoginOption - 1]
        when (loginOption) {
            LoginMenu.LOGIN -> {
                val currentUser: User? = logIntoWebsite()
                if (currentUser != null) {
                    manageWithUserMenu(currentUser)
                }else{
                    showMessage("*** Mismatch User, wrong username or password *** \n")
                }
            }
            LoginMenu.EXIT -> showMessage("Goodbye, Have a nice day!")
        }
    } while (loginOption != LoginMenu.EXIT)
}

private fun manageWithUserMenu(currentUser: User) {
    var currentEvent: Event? = null
    do {
        val menu = UserMenu.entries
        showUserMenu(menu)
        val selectedOption: Int = evaluateEnteredOption(6)
        val option: UserMenu = UserMenu.entries[selectedOption - 1]
        when (option) {
            UserMenu.VIEW_ACCOUNT_MONEY -> showUserWallet(currentUser)
            UserMenu.VIEW_SELECT_SPORTING_EVENT -> TODO()
            UserMenu.VIEW_SHOPPING_CART -> viewSelectedEvents(currentEvent)
            UserMenu.VIEW_HISTORY -> TODO()
            UserMenu.MAKE_A_PURCHASE -> TODO()
            UserMenu.VIEW_OLYMPIC_MEDAL_TABLE -> TODO()
            UserMenu.LOG_OUT_USER -> showMessage("*** SUCCESSFUL SYSTEM LOGOUT, SEE YOU LATER!!! ***")
        }
    } while (option != UserMenu.LOG_OUT_USER)
}

fun viewSelectedEvents(currentEvent: Event?) {
    if (currentEvent != null) {
        showMessage("*** Your shopping cart contains the following Sporting Event ***")
        showMessage("***********************************************************")
        showMessage("*** SPORT: ${currentEvent.sport.name} \n" +
                "*** DATE: ${currentEvent.date} \n" +
                "*** PLACE: ${currentEvent.place}\n" +
                "*** SCHEDULE: ${currentEvent.hour} \n" +
                "*** PRICE: ${currentEvent.price} \n" +
                "*** LOGO: ${currentEvent.sport.logo} \n" +
                "*** STARS: ${currentEvent.sport.stars} \n" +
        showMessage("***********************************************************")
    }else{
        showMessage(" *** No Matches!, empty shopping cart, first select a Sporting Event with option 2 ***\n")
    }
}

private fun logIntoWebsite(): User? {
    val currentUser : User?
    val userName = evaluateEnteredString("Enter username:")
    val userPassword = evaluateEnteredString("Enter password:")

    currentUser = UserRepository.login(userName, userPassword)
    if (currentUser != null) {
        showMessage(" *** SUCCESSFUL LOGIN ***  \n *** Welcome ${currentUser.nickName} ***")
    }
    return currentUser
}

private fun showUserWallet(currentUser: User){
    showMessage("*** The money available in your wallet is: ${currentUser.money} *** \n")
}

fun evaluateEnteredString(message: String): String {
    var validEntry = false
    var dataEntry  = ""
    do {
        try {
            showMessage(message)
            dataEntry = validateInputOfStringTypeData(readln())
            if (dataEntry.isNotBlank() ){
                validEntry = true
            }
        } catch (exception: CustomException) {
            println(exception.message)
        }
    }while (!validEntry)
    return dataEntry
}

private fun evaluateEnteredOption(maximumValue: Int): Int{
    val minimumValue = 1
    var option = 0
    var validEntry = false
    do {
        try {
            showMessage("Enter the desired option: ")
            option = validateInputOfNumericTypeData(readln())
            if(option in minimumValue..maximumValue){
                validEntry = true
            }else{
                showMessage("\n *** Error, invalid entry out of range. Please try again. *** \n")
            }
        } catch (exception: CustomException){
            print(exception.message)
        }
    } while (!validEntry)
    return option
}

fun showMessage(message: String) = println(message)

private fun showLoginMenu(menu: EnumEntries<LoginMenu>) {
    showMessage("*****************************************************")
    showMessage("***  Welcome to the Los borbotones system TourApp ***")
    showMessage("***************    OPTION MENU     ******************")
    for (i in menu.indices) {
        showMessage(menu[i].toString())
    }
    showMessage("*****************************************************\n")
}

private fun showUserMenu(menu: EnumEntries<UserMenu>) {
    showMessage("*********************************************************")
    showMessage("******************     OPTION MENU     ******************")
    for (i in menu.indices) {
        showMessage(menu[i].toString())
    }
    showMessage("*********************************************************\n")
}
