package com.raywenderlich.flashscore.ui.matches

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.raywenderlich.flashscore.databinding.FragmentHomeBinding
import com.raywenderlich.flashscore.models.Match
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class HomeFragment : Fragment() {



    private  var binding: FragmentHomeBinding? = null

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (binding == null){
            binding = FragmentHomeBinding.inflate(inflater,container,false)
            load()
        }
        return binding?.root
    }

    private fun load(){
        viewModel.load()
        viewModel.data.observe(viewLifecycleOwner){
            binding.apply {
                this!!.dateTxt.text = getDate(it.matchDate!!)
                stadiumTxt.text = it.stadiumAdress.toString()
                leftTeamScore.text = it.team1?.score.toString()
                leftTeamnameTxt.text = it.team1?.teamName.toString()
                rightTeamScore.text = it.team2?.score.toString()
                rightteamnameTxt.text = it.team2?.teamName.toString()
                matchTime.text = it.matchTime.toString()
                rightTeamBallPercent.text = it.team2?.ballPosition.toString()
                leaftTeamBallPercent.text = it.team1?.ballPosition.toString()
                ballPosition.progress = it.team1?.ballPosition!!
                firstHalfScore.text = it.team1.score.toString() + ":" + it.team2?.score.toString()
                Picasso.get().load(it.team1.teamImage).into(leftTeamImg)
                Glide.with(requireContext()).load(it.team2?.teamImage)
                    .into(rightTeamImg)

                bindMainRecycler(it)


            }
        }
    }

    private fun bindMainRecycler(data: Match){
        adapter = MainAdapter()
        binding?.mainRecyclerView?.layoutManager = GridLayoutManager(requireContext(),1)
        binding?.mainRecyclerView?.adapter = adapter
        adapter.data = data.matchSummary!!.summaries
    }

    private fun getDate(data: Long):String{
        var dateFormat = SimpleDateFormat("d MMMM yyyy")
        val dateString = dateFormat.format(data)
        return dateString
    }

}