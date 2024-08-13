package com.example.fly.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fly.R
import com.example.fly.data.local.entities.Flight

//class UserAdapter(
//    private var users: List<User>,
//    private val onItemClick: (User) -> Unit // Click listener function
//) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
//
//    // Create ViewHolder
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
//        return UserViewHolder(view)
//    }
//
//    // Bind data to ViewHolder
//    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
//        val user = users[position]
//        holder.bind(user)
//        holder.itemView.setOnClickListener { onItemClick(user) } // Set click listener
//    }
//
//    // Return the size of the data list
//    override fun getItemCount(): Int = users.size
//
//    // Update the data
//    fun updateData(newUsers: List<User>) {
//        users = newUsers
//        notifyDataSetChanged()
//    }
//
//    // ViewHolder class to hold item views
//    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(user: User) {
//            itemView.findViewById<TextView>(R.id.userNameTextView).text = user.name
//            itemView.findViewById<TextView>(R.id.userAgeTextView).text = user.age.toString()
//        }
//    }
//}
class UserAdapter(
    private var flights: List<Flight>,
    private val onItemClick: (Flight) -> Unit // Click listener function
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    // Bind data to ViewHolder
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = flights[position]
        holder.bind(user)
        holder.itemView.setOnClickListener { onItemClick(user) } // Set click listener
    }

    // Return the size of the data list
    override fun getItemCount(): Int = flights.size

    // Update the data
    fun updateData(newFlights: List<Flight>) {
        flights = newFlights
        notifyDataSetChanged()
    }

    // ViewHolder class to hold item views
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flight: Flight) {
            itemView.findViewById<TextView>(R.id.userNameTextView).text = flight.name
            itemView.findViewById<TextView>(R.id.userAgeTextView).text = flight.age.toString()
            //itemView.findViewById<TextView>(R.id.passengerNameTextView).text = user.passengerName
            itemView.findViewById<TextView>(R.id.flightNumberTextView).text = flight.flightNumber
            itemView.findViewById<TextView>(R.id.departureTextView).text = flight.departure
            itemView.findViewById<TextView>(R.id.destinationTextView).text = flight.destination
            itemView.findViewById<TextView>(R.id.dateTextView).text = flight.date
        }
    }
}