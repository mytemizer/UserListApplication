package com.global.userlistapplication.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.global.userlistapplication.R
import com.global.userlistapplication.common.inflate
import com.global.userlistapplication.data.Person
import com.global.userlistapplication.databinding.ItemPersonInfoBinding

class PersonListAdapter : ListAdapter<Person, PersonListAdapter.PersonViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Person> =
            object : DiffUtil.ItemCallback<Person>() {
                override fun areItemsTheSame(
                    oldItem: Person,
                    newItem: Person
                ): Boolean = oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: Person,
                    newItem: Person
                ): Boolean = oldItem.fullName == newItem.fullName
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val itemBinding: ItemPersonInfoBinding =
            parent.inflate(
                R.layout.item_person_info,
                false
            )

        return PersonViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getPerson(position))
    }

    private fun getPerson(position: Int): Person = getItem(position)


    inner class PersonViewHolder(private val binding: ItemPersonInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            binding.itemViewState = PersonListItemViewState(person)
        }
    }
}

