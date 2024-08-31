package repositories
import data.User

object UserRepository {

    private val users = mutableListOf<User>()
    private var currentUser: User? = null

    init {
        users.add(User(1504L, "bbayarri", "abc123", "Brian", "Bayarri", 3500000.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 200000.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "@12345", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
        users.add(User(1754L, "Gabi", "1207", "Gabriel", "Pezet", 335000.5, "2023/01/20"))
        users.add(User(1765L, "Fede", "1128", "Federico", "Carrazan", 450500.5, "2024/08/31"))
    }

    fun login(nickname: String, password: String) : User? {
        this.currentUser = users.find { it.nickName.equals(nickname, ignoreCase = true) && it.password == password }
        return currentUser
    }

    fun modifyWallet(currentUser: User, eventCost: Double ) {
        val user = users.find { it == currentUser }
        user!!.money -= eventCost
    }

}