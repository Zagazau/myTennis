package com.example.mytennis

import Torneio
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TorneioAdapter(private var torneios: List<Torneio>) : RecyclerView.Adapter<TorneioAdapter.TorneioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TorneioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_torneio, parent, false)
        return TorneioViewHolder(view)
    }

    override fun onBindViewHolder(holder: TorneioViewHolder, position: Int) {
        val torneio = torneios[position]
        holder.nomeTorneio.text = torneio.nome
        holder.dataTorneio.text = torneio.data_inicio
    }

    override fun getItemCount(): Int {
        return torneios.size
    }

    fun updateTorneios(novosTorneios: List<Torneio>) {
        this.torneios = novosTorneios
        notifyDataSetChanged()
    }

    class TorneioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTorneio: TextView = itemView.findViewById(R.id.textViewNomeTorneio)
        val dataTorneio: TextView = itemView.findViewById(R.id.textViewDataTorneio)
    }
}
