package UserInterface

import data.Event
import data.User
import repositories.EventRepository
import repositories.PurchaseRepository
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
            UserMenu.VIEW_SELECT_SPORTING_EVENT -> selectSportingEvent().also { currentEvent = it }
            UserMenu.VIEW_SHOPPING_CART -> viewSelectedEvents(currentEvent)
            UserMenu.VIEW_HISTORY -> listPurchaseHistory(currentUser)
            UserMenu.MAKE_A_PURCHASE -> TODO()
            UserMenu.VIEW_OLYMPIC_MEDAL_TABLE -> TODO()
            UserMenu.LOG_OUT_USER -> showMessage("*** SUCCESSFUL SYSTEM LOGOUT, SEE YOU LATER!!! ***")
        }
    } while (option != UserMenu.LOG_OUT_USER)
}

fun listPurchaseHistory(currentUser: User) {
    val purchasesHistoryCurrentUser = PurchaseRepository.getPurchaseHistoryCurrentUser(currentUser)
    if(purchasesHistoryCurrentUser.isNotEmpty()){
        showMessage("DEAR ${currentUser.name}. THIS IS YOU PURCHASE HISTORY")
        for (j in purchasesHistoryCurrentUser.indices ) {
            showMessage("***********************************************************")
            showMessage("*** EVENT PURCHASED: ${EventRepository.getById(purchasesHistoryCurrentUser[j].eventId).sport} \n" +
                        "*** PURCHASE CODE: ${purchasesHistoryCurrentUser[j].id} \n" +
                        "*** PURCHASE DATE: ${purchasesHistoryCurrentUser[j].createdDate} \n" +
                        "*** SEAT: ${purchasesHistoryCurrentUser[j].seat} \n" +
                        "*** TOTAL PRICE: ${purchasesHistoryCurrentUser[j].amount}"
            )
            showMessage("***********************************************************")
        }
    } else {
        showMessage("*** Error, empty history. You have not made any purchases yet. ***\n")
    }
}

private fun selectSportingEvent(): Event {
    val selectEvent: Event
    listEventRepository()
    showMessage("Select the ID of the Event you wish to purchase: ")
    val idEvent = evaluateEnteredOption(EventRepository.getEventList().size).toLong()
    EventRepository.getById(idEvent).also { selectEvent = it }
    // NOTA: La linea de código de arriba es la versión pro de esto  /selectEvent = EventRepository.getById(idEvent)/

    showMessage("""You have selected the following sporting event: """)
    showMessage("SPORT: ${selectEvent.sport}")
    showMessage("LOGO: ${selectEvent.sport.logo}")
    showMessage("STARS: ${selectEvent.sport.stars}")
    showMessage("DATE: ${selectEvent.date}")
    showMessage("PLACES: ${selectEvent.place}")
    showMessage("SCHEDULE: ${selectEvent.hour}")
    showMessage("PRICE: ${selectEvent.price}")
    return selectEvent
}

fun listEventRepository() {
    val list = EventRepository.getEventList()
    for (i in list.indices) {
        showMessage("ID: ${list[i].id}")
        showMessage("SPORT: ${list[i].sport}*")
        showMessage("DATE: ${list[i].date}***")
        showMessage("PLACE: ${list[i].place}*")
        showMessage("SCHEDULE:${list[i].hour}")
        showMessage("PRICE: ${list[i].price}*")
        showMessage("************************")
    }
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
                "*** STARS: ${currentEvent.sport.stars}")
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
    showMessage("***  Welcome to the Program Mobile system TourApp ***")
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
