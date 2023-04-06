package com.example.doctorathome.database

import androidx.room.*
import androidx.room.RoomDatabase

// Step 1: Define a data model
data class User(
    val name: String,
    val email: String,
    val phone: String
)

// Step 2: Create a Room Database
@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

// Step 3: Define DAO
@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>
}

// Step 4: Implement database operations
class UserRepository(private val userDao: UserDao) {
    fun addUser(user: User) {
        userDao.insertUser(user)
    }

    fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }
}

// Step 5: Collect data from text fields
var name by remember { mutableStateOf("") }
var email by remember { mutableStateOf("") }
var phone by remember { mutableStateOf("") }

TextField(
value = name,
onValueChange = { name = it }
)

TextField(
value = email,
onValueChange = { email = it }
)

TextField(
value = phone,
onValueChange = { phone = it }
)

// Step 6: Save data to the database
val userRepository = UserRepository(database.userDao())

Button(
onClick = {
    val user = User(name = name, email = email, phone = phone)
    userRepository.addUser(user)
}
) {
    Text("Save User")
}
