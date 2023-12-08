package com.nashir.tugaskotlinend.adapter
//import com.nashir.tugaskotlinend.HomeActivity
//import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nashir.tugaskotlinend.databinding.RsItemBinding
import com.nashir.tugaskotlinend.model.Hospital

class RsAdapter (private val hospitalList: List<Hospital>) : RecyclerView.Adapter<RsAdapter.ViewHolder>(){

    class ViewHolder(val binding: RsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RsItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = hospitalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(hospitalList[position]) {
                binding.imageRs.setImageResource(this.image)
                binding.name.text = this.name
                binding.alamat.text = this.alamat
                binding.phonenumber.text = this.phonenumber
            }
        }
}
}

