package com.ng.ui.show.frag

import android.view.View
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatSeekBar
import com.ng.ui.R
import com.ng.ui.other.soundwaveview.SoundView

/**
 * 描述:
 * @author Jzn
 * @date 2020-06-12
 */
class SvFragment : BaseFragment() {
    private lateinit var mysc: SoundView
    private lateinit var button3: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var yinliang: AppCompatSeekBar

    override fun initViewsAndEvents(v: View) {
        mysc = v.findViewById(R.id.mysc)
        button3 = v.findViewById(R.id.button3)
        button4 = v.findViewById(R.id.button4)
        yinliang = v.findViewById(R.id.yinliang)
        button3.setOnClickListener {
            mysc.startWaveAnim()
        }
        button4.setOnClickListener {
            mysc.stopWaveAnim()
        }

        yinliang.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mysc.setVolume(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }


    override fun onStart() {
        super.onStart()
        mysc.post {
            //   mysc.startBallAnim()
            mysc.setVolume(80)
            mysc.startWaveAnim()

        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_sv
}