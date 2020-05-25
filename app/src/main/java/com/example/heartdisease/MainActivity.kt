package com.example.heartdisease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.heartdisease.data.data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapterCondition: ArrayAdapter<String>
    private lateinit var adapterSex: ArrayAdapter<String>
    private lateinit var adapterPain: ArrayAdapter<String>
    private lateinit var adapterGraphic: ArrayAdapter<String>

    private var condition = 0
    private var sex = 0
    private var pain = 0
    private var graphic = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterCondition =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data.conditions)
        adapterCondition.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        spCondition.adapter = adapterCondition
        spCondition.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                condition = position
            }

        }

        adapterSex = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data.sex)
        adapterSex.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        spSex.adapter = adapterSex
        spSex.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                sex = position
            }

        }

        adapterPain =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data.painType)
        adapterPain.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        spPainType.adapter = adapterPain
        spPainType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                pain = position
            }

        }

        adapterGraphic =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data.painType)
        adapterGraphic.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        spElectrocarDiographic.adapter = adapterGraphic
        spElectrocarDiographic.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    graphic = position
                }

            }
        btnResult.setOnClickListener {
            statute()
        }

    }

    private fun statute() {
        when (condition) {
            0 -> {
                if (edFlour.text.toString().toDouble() <= 0) {
                    if (edBlood.text.toString().toDouble() <= 156) {
                        showResult("No")
                    } else {
                        if (edAge.text.toString().toInt() <= 62) {
                            showResult("Yes")
                        } else {
                            showResult("No")
                        }
                    }
                } else {
                    when (pain) {
                        0 -> {
                            if (edSlope.text.toString().toDouble() <= 1) {
                                showResult("No")
                            } else {
                                showResult("Yes")
                            }
                        }
                        1 -> {
                            showResult("No")
                        }

                        2 -> {
                            showResult("No")
                        }

                        3 -> {
                            if (sex == 1) {
                                if (edSlope.text.toString().toDouble() <= 1) {
                                    showResult("No")
                                } else {
                                    showResult("Yes")
                                }
                            } else {
                                showResult("Yes")
                            }
                        }
                    }
                }
            }

            1 -> {
                if (edFlour.text.toString().toDouble() <= 0) {
                    showResult("No")
                } else {
                    showResult("Yes")
                }
            }

            2 -> {
                when (pain) {
                    0 -> {
                        showResult("No")
                    }
                    1 -> {
                        if (edOldPeak.text.toString().toDouble() <= 0.1) {
                            showResult("No")
                        } else {
                            showResult("Yes")
                        }
                    }
                    2 -> {
                        if (edOldPeak.text.toString().toDouble() <= 1.9) {
                            if (edSlope.text.toString().toDouble() <= 1) {
                                showResult("No")
                            } else {
                                if (edBlood.text.toString().toDouble() <= 122) {
                                    showResult("No")
                                } else {
                                    showResult("Yes")
                                }
                            }
                        } else {
                            showResult("Yes")
                        }
                    }
                    3 -> {
                        if (edOldPeak.text.toString().toDouble() <= 0.6) {
                            when (graphic) {
                                0 -> {
                                    if (edHeartBeat.text.toString().toDouble() <= 151) {
                                        showResult("No")
                                    } else {
                                        if (edFlour.text.toString().toDouble() <= 0) {
                                            showResult("No")
                                        } else {
                                            showResult("Yes")
                                        }
                                    }

                                }
                                1, 2 -> {
                                    showResult("Yes")
                                }
                            }
                        } else {
                            showResult("Yes")
                        }
                    }
                }
            }
        }
    }

    private fun showResult(result: String) {
        llResult.visibility = View.VISIBLE
        tvResult.text = "$result Heart Disease"
    }
}
