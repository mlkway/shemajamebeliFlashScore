package com.raywenderlich.flashscore.ui.matches

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.flashscore.R
import com.raywenderlich.flashscore.databinding.RighItemBinding
import com.raywenderlich.flashscore.models.Summary

class RightAdapter(private val data: Summary?):RecyclerView.Adapter<RightAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RightAdapter.ViewHolder {
        return ViewHolder(RighItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()= data?.team2Action?.size ?: 0

    override fun onBindViewHolder(holder: RightAdapter.ViewHolder, position: Int) {
        holder.bind()
    }




    inner class ViewHolder(private val binding: RighItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(){
            var actionType = data?.team2Action?.get(adapterPosition)?.actionType
            when(actionType){
                1 -> goal()
                2 -> yellowCard()
                3 -> redCard()
                4 -> substitution()
            }


        }


        fun substitution(){
            binding.textView7.text = "Substitution"
            binding.textView6.text = data?.team2Action?.get(adapterPosition)?.action?.player1?.playerName
            binding.gasulimotamashe.text = data?.team2Action?.get(adapterPosition)?.action?.player2?.playerName
            binding.gasvla.setImageResource(R.drawable.ic_gasvla)
            binding.gasvla.isVisible = true
            binding.imageView6.setImageResource(R.drawable.ic_shemosvla)



        }

        fun yellowCard(){
            binding.apply {
                textView5.text = data?.actionTime.toString() + "'"
                textView6.text = data?.team2Action?.get(adapterPosition)?.action?.player1?.playerName
                textView7.text = "Tripping"
                imageView6.setImageResource(R.drawable.ic_yellowcard)

            }
        }
        fun redCard(){
            binding.apply {
                textView5.text = data?.actionTime.toString() + "'"
                textView6.text = data?.team2Action?.get(adapterPosition)?.action?.player1?.playerName
                textView7.text = "Tripping"
                imageView6.setImageResource(R.drawable.ic_yellowcard)
                imageView6.setColorFilter(Color.RED)

            }
        }

        fun goal(){
            var goal = data?.team2Action?.get(adapterPosition)?.action?.goalType
            when(goal){
                1 -> drawGoal(goal)
            }
        }

        @SuppressLint("SetTextI18n")
        fun drawGoal(tp: Int){
            binding.apply {
                textView5.text = data?.actionTime.toString() + "'"
                textView6.text = data?.team2Action?.get(adapterPosition)?.action?.player1?.playerName
                textView7.text = if (tp == 1) "Goals By" else "Own Goal"
                if (tp == 1){
                    imageView6.setImageResource(R.drawable.ic_greenball)
                }else{
                    imageView6.setImageResource(R.drawable.ic_redball)
                }
            }
        }
    }



}