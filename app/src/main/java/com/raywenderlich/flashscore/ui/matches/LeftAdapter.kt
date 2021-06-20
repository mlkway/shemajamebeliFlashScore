package com.raywenderlich.flashscore.ui.matches

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.flashscore.R
import com.raywenderlich.flashscore.databinding.LeftItemBinding
import com.raywenderlich.flashscore.models.Summary

class LeftAdapter(private val data: Summary?):RecyclerView.Adapter<LeftAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeftAdapter.ViewHolder {
        return ViewHolder(LeftItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LeftAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()= data?.team1Action?.size ?: 0

    inner class ViewHolder(private val binding: LeftItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(){
            var actionType = data?.team1Action?.get(adapterPosition)?.actionType
            when(actionType){
                  1 -> goal()
                  2 -> yellowCard()
                  3 -> redCard()
                  4 -> substitution()
            }


        }


        fun substitution(){
             binding.actionNameTxt.text = "Substitution"
             binding.actionPersonTxt.text = data?.team1Action?.get(adapterPosition)?.action?.player1?.playerName
             binding.player2Txt.text = data?.team1Action?.get(adapterPosition)?.action?.player2?.playerName
            binding.imageView7.setImageResource(R.drawable.ic_gasvla)
            binding.actionImg.setImageResource(R.drawable.ic_shemosvla)



        }

        fun yellowCard(){
            binding.apply {
                actionTimeTxt.text = data?.actionTime.toString() + "'"
                actionPersonTxt.text = data?.team1Action?.get(adapterPosition)?.action?.player1?.playerName
                actionNameTxt.text = "Tripping"
                actionImg.setImageResource(R.drawable.ic_yellowcard)
            }
        }
        fun redCard(){
            binding.apply {
                actionTimeTxt.text = data?.actionTime.toString() + "'"
                actionPersonTxt.text = data?.team1Action?.get(adapterPosition)?.action?.player1?.playerName
                actionNameTxt.text = "Tripping"
                actionImg.setImageResource(R.drawable.ic_yellowcard)
                actionImg.setColorFilter(Color.RED)

            }
        }

        fun goal(){
            var goal = data?.team1Action?.get(adapterPosition)?.action?.goalType
            when(goal){
                1 -> drawGoal(goal)
            }
        }

        @SuppressLint("SetTextI18n")
        fun drawGoal(tp: Int){
            binding.apply {
                actionTimeTxt.text = data?.actionTime.toString() + "'"
                actionPersonTxt.text = data?.team1Action?.get(adapterPosition)?.action?.player1?.playerName
                actionNameTxt.text = if (tp == 1) "Goals By" else "Own Goal"
                if (tp == 1){
                    actionImg.setImageResource(R.drawable.ic_greenball)
                }else{
                    actionImg.setImageResource(R.drawable.ic_redball)
                }
            }
        }


    }


}