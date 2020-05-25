package com.example.heartdisease.data

object data {
     val conditions= arrayListOf<String>("normal","fixed defect","reversable defect")
    val flourosopy = arrayListOf<String>("<=0",">0")
    val bloodPressure1 = arrayListOf<String>("<=156",">156")
    val bloodPressure2 = arrayListOf<String>("<=151",">151")
    val painType = arrayListOf<String>("typical angina","atypical angina","non-anginal pain","asymptomatic")
    val oldPeak2 = arrayListOf<String>("<=0.1",">0.1")
    val oldPeak3= arrayListOf<String>("<=1.9",">1.9")
    val oldPeak4 = arrayListOf<String>("<=0.6",">0.6")
    val oldPeaks = arrayListOf<ArrayList<String>>(oldPeak2, oldPeak3, oldPeak4)
    val age = arrayListOf<String>("<=62",">62")
    val slope = arrayListOf<String>("<=1",">1")
    val sex = arrayListOf<String>("male","female")
    val restecg = arrayListOf<String>("normal","having ST-T wave abnormality","showing probable or definite left ventricular hypertrophy")
    val heartBeat = arrayListOf<String>("<=151",">151")
}